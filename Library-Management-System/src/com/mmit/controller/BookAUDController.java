package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Index;
import com.mmit.model.entity.Author;
import com.mmit.model.entity.Book;
import com.mmit.model.entity.Category;
import com.mmit.model.entity.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookAUDController implements Initializable{
	List<Category> cateList;
	List<Author> authList;
	private Book selected_book;
	 @FXML
	    private ComboBox<String> cbo_author;

	    @FXML
	    private ComboBox<String> cbo_category;

	    @FXML
	    private TableColumn<Book, String> col_author;

	    @FXML
	    private TableColumn<Book, Boolean> col_available;

	    @FXML
	    private TableColumn<Book, String> col_category;

	    @FXML
	    private TableColumn<Book, Integer> col_code;

	    @FXML
	    private TableColumn<Book, LocalDate> col_publish_date;

	    @FXML
	    private TableColumn<Book, String> col_title;
	    
	    @FXML
	    private TableColumn<Book, String> col_librarian;

	    @FXML
	    private TableView<Book> tbl_book;

	    @FXML
	    private TextField txt_code;

	    @FXML
	    private DatePicker txt_publish_date;

	    @FXML
	    private TextField txt_title;

	    @FXML
	    void back_click(MouseEvent event) throws IOException {
	    	Index.changeScene("view/Book.fxml", "Book Information");
	    }

	    @FXML
	    void btn_add_click(ActionEvent event) {
	    	try {
	    		var code = txt_code.getText();
		    	var title = txt_title.getText();
		    	var publishDate = txt_publish_date.getValue();
		    	if(code.isEmpty()) {
		    		showAlert(AlertType.ERROR, "Code is required");
		    		return;
		    	}
		    	if(title.isEmpty()) {
		    		showAlert(AlertType.ERROR, "Title is required");
		    		return;
		    	}
		    	if(publishDate == null) {
		    		showAlert(AlertType.ERROR, "Publish date is required");
		    		return;
		    	}
		    	if(publishDate.isAfter(LocalDate.now())) {
		    		showAlert(AlertType.ERROR, "Publish date is invalid");
		    		return;
		    	}
		    	
		    	var cate_index = cbo_category.getSelectionModel().getSelectedIndex();
		    	var auth_index = cbo_author.getSelectionModel().getSelectedIndex();
		    	if(cate_index < 0) {
		    		showAlert(AlertType.ERROR, "Category is required");
		    		return;
		    	}
		    	if(auth_index < 0) {
		    		showAlert(AlertType.ERROR, "Author is required");
		    		return;
		    	}
				var category = cateList.get(cate_index);
		    	var author = authList.get(auth_index);
		    	
		    	var book = new Book();
		    	book.setCode(Integer.parseInt(code));
		    	book.setTitle(title);
		    	book.setPublishDate(publishDate);
		    	book.setAuthor(author);
		    	book.setCategory(category);
		    	book.setAvailable(true);
		    	book.setLib(Index.login_user);
		    	
		    	DatabaseHandler.addBook(book);
		    	showAlert(AlertType.INFORMATION, "Success");
		    	clearData();
		    	showBook();

	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    private Optional<ButtonType> showAlert(AlertType type, String msg) {
			Alert alert = new Alert(type);
			alert.setContentText(msg);
			alert.setHeaderText(null);
			alert.setTitle("Message");
			return alert.showAndWait();
		}

		@FXML
	    void btn_delete_click(ActionEvent event) {
			try {
				if(txt_code.getText().isEmpty()) {
					showAlert(AlertType.ERROR, "Select the book in the table that you want to delete");
					return;
				}
				Optional<ButtonType> result = showAlert(AlertType.CONFIRMATION, "Are you sure want to delete?");
				if(result.get() == ButtonType.OK) {
					DatabaseHandler.deleteBook(selected_book);
					clearData();
					showBook();
				}
			}
			catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    @FXML
	    void btn_logout_click(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void btn_reset_click(ActionEvent event) {
	    	clearData();
	    }

	    private void clearData() {
	    	txt_code.setText(null);
	    	txt_publish_date.setValue(null);
	    	txt_title.setText(null);
	    	cbo_author.getSelectionModel().clearSelection();
	    	cbo_category.getSelectionModel().clearSelection();
		}

		@FXML
	    void btn_update_click(ActionEvent event) {
			try {
				if(txt_code.getText().isEmpty()) {
					showAlert(AlertType.ERROR, "Select the book in the table that you want to update");
					return;
				}
				
				// get data
				var code = txt_code.getText();
				var title = txt_title.getText();
				var publishDate = txt_publish_date.getValue();
				var cat_index = cbo_category.getSelectionModel().getSelectedIndex();
				var auth_index = cbo_author.getSelectionModel().getSelectedIndex();
				
				// set data to object's field
				selected_book.setCode(Integer.parseInt(code));
				selected_book.setTitle(title);
				selected_book.setPublishDate(publishDate);
				selected_book.setCategory(cateList.get(cat_index));
				selected_book.setAuthor(authList.get(auth_index));
				//System.out.println(selected_book.getCategory().getId());
				DatabaseHandler.updateBook(selected_book);
				showAlert(AlertType.INFORMATION, "Update success");
				clearData();
				showBook();
			}
			catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			col_publish_date.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			col_available.setCellValueFactory(new PropertyValueFactory<>("available"));
			col_librarian.setCellValueFactory(new PropertyValueFactory<>("entryBy"));
			
			showBook();
			
			cateList= DatabaseHandler.findAllCategory();
			 
			authList = DatabaseHandler.findAllAuthor();
			
			List<String> categories = cateList.stream()
										.map(c -> c.getName())
										.toList();
			List<String> authors = authList.stream()
										.map(a -> a.getName())
										.toList();
			
			cbo_category.setItems(FXCollections.observableArrayList(categories));
			cbo_author.setItems(FXCollections.observableArrayList(authors));
			
			tbl_book.getSelectionModel().selectedItemProperty()
			.addListener(
					(obs, old_select, new_select) -> {
						selected_book = tbl_book.getSelectionModel().getSelectedItem();
						txt_code.setText(String.valueOf(selected_book.getCode()));
						txt_publish_date.setValue(selected_book.getPublishDate());
						txt_title.setText(selected_book.getTitle());
						cbo_author.getSelectionModel().select(selected_book.getAuthorName());
				    	cbo_category.getSelectionModel().select(selected_book.getCategoryName());
					}
				);
		}

		private void showBook() {
			
			List<Book> list = DatabaseHandler.findAllBook();
			tbl_book.setItems(FXCollections.observableArrayList(list));
			
		}
}
