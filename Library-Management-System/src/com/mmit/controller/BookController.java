package com.mmit.controller;

import java.io.IOException;

import com.mmit.Index;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class BookController {
	
	@FXML
    void back_click(MouseEvent event) throws IOException {
		Index.changeScene("view/Menu.fxml", "Library Management System");
    }

    @FXML
    void books_AUD_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/BookAUD.fxml", "Add/Update/Delete Books");
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void view_books_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/BookView.fxml", "View Books");
    }
}
