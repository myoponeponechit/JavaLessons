package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.entity.Book;
import com.mmit.model.entity.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookViewController implements Initializable{
	
	 @FXML
	    private TableColumn<Book, String> col_author;

	    @FXML
	    private TableColumn<Book, String> col_category;

	    @FXML
	    private TableColumn<Book, Integer> col_code;

	    @FXML
	    private TableColumn<Book, String> col_entryBy;

	    @FXML
	    private TableColumn<Book, Double> col_price;

	    @FXML
	    private TableColumn<Book, LocalDate> col_publishDate;

	    @FXML
	    private TableColumn<Book, String> col_title;

	    @FXML
	    private TableView<Book> tbl_book;
	    
	    @FXML
	    void back_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Book.fxml", "Book");
	    }
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
			col_publishDate.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			col_entryBy.setCellValueFactory(new PropertyValueFactory<>("entryName"));
			
			List<Book> list = DatabaseHandler.findAllBook();
			
			tbl_book.setItems(FXCollections.observableArrayList(list));
			
		}
}
