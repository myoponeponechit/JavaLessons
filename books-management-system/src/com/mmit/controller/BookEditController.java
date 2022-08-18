package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BookEditController implements Initializable{
	private List<Author> authorList;
	private List<Category> catList;
	private Book search_book;
	 @FXML
	    private ComboBox<String> cbo_author;

	    @FXML
	    private ComboBox<String> cbo_category;

	    @FXML
	    private TextField txt_code;

	    @FXML
	    private TextField txt_price;

	    @FXML
	    private DatePicker txt_publishDate;

	    @FXML
	    private TextField txt_title;

	    @FXML
	    void back_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Book.fxml", "Book");
	    }

	    @FXML
	    void btn_delete_click(ActionEvent event) {
	    	try {
	    		Optional<ButtonType> result = showAlert(AlertType.CONFIRMATION, "Are you sure to delete?");
	    		if(result.get() == ButtonType.OK) {
	    			// get data
					var title = txt_title.getText();
					var price = txt_price.getText();
					var publishDate = txt_publishDate.getValue();
					var cat_index = cbo_category.getSelectionModel().getSelectedIndex();
					var auth_index = cbo_author.getSelectionModel().getSelectedIndex();
					
					// set data to object's field
					search_book.setTitle(title);
					search_book.setPrice(Double.parseDouble(price));
					search_book.setPublishDate(publishDate);
					search_book.setCategory(catList.get(cat_index));
					search_book.setAuthor(authorList.get(auth_index));
					
					// delete
					DatabaseHandler.deleteBook(search_book);
					clearData();
	    		}
	    		
	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, "Something is wrong");
			}
	    }

	    @FXML
	    void btn_search_cllick(ActionEvent event) {
	    	var code = txt_code.getText();
	    	if(code.isEmpty()) {
	    		showAlert(AlertType.ERROR, "Code is required!");
	    		return;
	    	}
	    	search_book = DatabaseHandler.findByCode(Integer.parseInt(code));
	    	if(search_book == null) {
	    		showAlert(AlertType.ERROR, code + " is invalid!");
	    		return;
	    	}
	    	
	    	txt_code.setText(String.valueOf(search_book.getCode()));
	    	txt_title.setText(search_book.getTitle());
	    	txt_price.setText(String.valueOf(search_book.getPrice()));
	    	txt_publishDate.setValue(search_book.getPublishDate());
	    	
	    	cbo_author.getSelectionModel().select(search_book.getAuthorName());
	    	cbo_category.getSelectionModel().select(search_book.getCategoryName());
	    }

	    private Optional<ButtonType> showAlert(AlertType type, String msg) {
			Alert alert = new Alert(type);
			alert.setContentText(msg);
			alert.setHeaderText(null);
			alert.setTitle("Message");
			return alert.showAndWait();
		}

		@FXML
	    void btn_update_click(ActionEvent event) {
			try {
				// get data
				var title = txt_title.getText();
				var price = txt_price.getText();
				var publishDate = txt_publishDate.getValue();
				var cat_index = cbo_category.getSelectionModel().getSelectedIndex();
				var auth_index = cbo_author.getSelectionModel().getSelectedIndex();
				
				// set data to object's field
				search_book.setTitle(title);
				search_book.setPrice(Double.parseDouble(price));
				search_book.setPublishDate(publishDate);
				search_book.setCategory(catList.get(cat_index));
				search_book.setAuthor(authorList.get(auth_index));
				
				// update
				DatabaseHandler.updateBook(search_book);
				showAlert(AlertType.INFORMATION, "Update success");
				clearData();
			}
			catch (Exception e) {
				showAlert(AlertType.ERROR, "Somethind is wrong!");
			}
			
	    }

		private void clearData() {
			txt_code.setText(null);
			txt_title.setText(null);
			txt_price.setText(null);
			txt_publishDate.setValue(null);
			cbo_author.getSelectionModel().clearSelection();
			cbo_category.getSelectionModel().clearSelection();
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			authorList = DatabaseHandler.findAllAuthor();
			catList = DatabaseHandler.findAllCategory();
			
			List<String> authors = authorList.stream()
						.map(a -> a.getName())
						.toList();
			List<String> categories = catList.stream()
										.map(c -> c.getName())
										.toList();
			
			cbo_author.setItems(FXCollections.observableArrayList(authors));
			cbo_category.setItems(FXCollections.observableArrayList(categories));
			
		}
}
