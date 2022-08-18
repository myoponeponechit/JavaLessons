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

public class BookSearchController implements Initializable{
	
	@FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book, Integer> col_code;

    @FXML
    private TableColumn<Book, Double> col_price;

    @FXML
    private TableColumn<Book, LocalDate> col_publishDate;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TextField txt_author;

    @FXML
    private TextField txt_category;

    @FXML
    private DatePicker txt_publishDate;

    @FXML
    private TextField txt_title;
    
    @FXML
    private TableView<Book> tbl_book_search;

    @FXML
    void back_click(MouseEvent event) throws IOException {
    	Start.changeScene("view/Book.fxml", "Book");
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	try {
    		var title = txt_title.getText();
        	var publishDate = txt_publishDate.getValue();
        	var category = txt_category.getText();
        	var author = txt_author.getText();
        	
        	List<Book> list = DatabaseHandler.searchBook(title, publishDate, category, author);
        	
        	tbl_book_search.setItems(FXCollections.observableArrayList(list));
        	
        	txt_author.setText(null);
        	txt_category.setText(null);
        	txt_publishDate.setValue(null);
        	txt_title.setText(null);
    	}
    	catch (Exception e) {
			showAlert(AlertType.ERROR, "Something is wrong!");
		}
    }

	private void showAlert(AlertType type, String msg) {
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		alert.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		col_publishDate.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
	}

}
