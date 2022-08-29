package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.mmit.Index;
import com.mmit.model.entity.Book;
import com.mmit.model.entity.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookViewController implements Initializable{

	    @FXML
	    private TableColumn<Book, String> col_author;

	    @FXML
	    private TableColumn<Book, Boolean> col_available;

	    @FXML
	    private TableColumn<Book, String> col_category;

	    @FXML
	    private TableColumn<Book, Integer> col_code;

	    @FXML
	    private TableColumn<Book, String> col_entryby;

	    @FXML
	    private TableColumn<Book, LocalDate> col_publish_date;

	    @FXML
	    private TableColumn<Book, String> col_title;

	    @FXML
	    private TableView<Book> tbl_book;

	    @FXML
	    private TextField txt_author;

	    @FXML
	    private TextField txt_category;

	    @FXML
	    private TextField txt_librarian;
	    
	    @FXML
	    private TextField txt_available;

	    
	    @FXML
	    private TextField txt_title;
	    
	    @FXML
	    private DatePicker txt_publish_date;

	    @FXML
	    void back_click(MouseEvent event) throws IOException {
	    	Index.changeScene("view/Book.fxml", "Book");
	    }

	    private void showAlert(AlertType type, String msg) {
			Alert alert = new Alert(type);
			alert.setContentText(msg);
			alert.setHeaderText(null);
			alert.setTitle("Message");
			alert.show();
		}
	    
		@FXML
	    void btn_logout_click(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void btn_search_click(ActionEvent event) {
	    	try {
	    		var title = txt_title.getText();
	    		var publishDate = txt_publish_date.getValue();
	    		var category = txt_category.getText();
	    		var author = txt_author.getText();
	    		var lib = txt_librarian.getText();
	    		
	    		if(title.isEmpty() && publishDate == null && category.isEmpty() && author.isEmpty() && lib.isEmpty()) {
	    			showAlert(AlertType.ERROR, "Enter something that you want to search");
	    		}
	    		else {

		        	List<Book> list = DatabaseHandler.searchBook(title, publishDate, category, author, lib);
		        	
		        	tbl_book.setItems(FXCollections.observableArrayList(list));
		        	
		        	txt_author.setText(null);
		        	txt_category.setText(null);
		        	txt_publish_date.setValue(null);
		        	txt_title.setText(null);
		        	txt_available.setText(null);
		        	txt_librarian.setText(null);
	    		}
	        	
	    	}
	    	catch (Exception e) {
				//showAlert(AlertType.ERROR, e.getMessage());
	    		e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void btn_available_books(ActionEvent event) {
	    	List<Book> list = DatabaseHandler.findAvailable();
	    	tbl_book.setItems(FXCollections.observableArrayList(list));
	    }
	    
	    @FXML
	    void btn_view_all_click(ActionEvent event) {
	    	List<Book> list = DatabaseHandler.findAllBook();
			tbl_book.setItems(FXCollections.observableArrayList(list));	
		
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			col_available.setCellValueFactory(new PropertyValueFactory<>("available"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
			col_entryby.setCellValueFactory(new PropertyValueFactory<>("entryBy"));
			col_publish_date.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			
		}

}
