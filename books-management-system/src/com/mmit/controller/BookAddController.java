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

public class BookAddController implements Initializable{
	List<Category> catList;
	List<Author> authorList;
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
    void btn_reset_click(ActionEvent event) {
    	clearData();
    }

    @FXML
    void btn_save_click(ActionEvent event) {
    	try {
    		// get data from input
        	var code = txt_code.getText();
        	var title = txt_title.getText();
        	var price = txt_price.getText();
        	var publishDate = txt_publishDate.getValue();
        	
        	if(code.isEmpty()) {
        		showAlert(AlertType.ERROR, "Code is required!");
        		return;
        	}
        	if(title.isEmpty()) {
        		showAlert(AlertType.ERROR, "Title is required!");
        		return;
        	}
        	if(price.isEmpty()) {
        		showAlert(AlertType.ERROR, "Price is required!");
        		return;
        	}
        	if(publishDate == null) {
        		showAlert(AlertType.ERROR, "Publish date is required!");
        		return;
        	}
        	var category_index = cbo_category.getSelectionModel().getSelectedIndex();
        	var author_index = cbo_author.getSelectionModel().getSelectedIndex();
        	
        	if(category_index < 0) {
        		showAlert(AlertType.ERROR, "Category is required!");
        		return;
        	}
        	if(author_index < 0) {
        		showAlert(AlertType.ERROR, "Author is required!");
        		return;
        	}
        	var selected_category = catList.get(category_index);
        	var selected_author = authorList.get(author_index);
        	// create new book
        	var book = new Book();
        	// asing data to book obj
        	book.setAuthor(selected_author);
        	book.setCategory(selected_category);
        	book.setCode(Integer.parseInt(code));
        	book.setTitle(title);
        	book.setPrice(Double.parseDouble(price));
        	book.setPublishDate(publishDate);
        	book.setCreated_by(Start.login_user);
        	// save to db
        	DatabaseHandler.saveBook(book);
        	// show alert
        	showAlert(AlertType.INFORMATION, "Success");
        	clearData();
    	}
    	catch (Exception e) {
			showAlert(AlertType.ERROR, e.getMessage());
		}
    }

	private void clearData() {
		txt_code.setText(null);
		txt_price.setText(null);
		txt_publishDate.setValue(null);
		txt_title.setText(null);
		cbo_author.getSelectionModel().clearSelection();
		cbo_category.getSelectionModel().clearSelection();
	}

	private Optional<ButtonType> showAlert(AlertType type, String msg) {
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		return alert.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		catList= DatabaseHandler.findAllCategory();
		authorList = DatabaseHandler.findAllAuthor();
		
		List<String> categories = catList.stream()
									.map(c -> c.getName())
									.toList();
		List<String> authors = authorList.stream()
									.map(a -> a.getName())
									.toList();
		
		cbo_category.setItems(FXCollections.observableArrayList(categories));
		cbo_author.setItems(FXCollections.observableArrayList(authors));
		
	}
}
