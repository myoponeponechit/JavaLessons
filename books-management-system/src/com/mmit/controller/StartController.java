package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class StartController {
	
	@FXML
    void panel_author_click(MouseEvent event) throws IOException {
		Start.changeScene("view/Author.fxml", "Author");
    }

    @FXML
    void panel_book_click(MouseEvent event) throws IOException {
    	Start.changeScene("view/Book.fxml", "Book");
    }

    @FXML
    void panel_category_click(MouseEvent event) throws IOException {
    	Start.changeScene("view/Category.fxml", "Category");
    }
    
    @FXML
    void back_click(MouseEvent event) throws IOException {
    	Start.changeScene("view/Login.fxml", "Book Management System.Login");
    }

}
