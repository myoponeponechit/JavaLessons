package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class BookController {
	
	 @FXML
	    void back_click(MouseEvent event) throws IOException {
		 	Start.changeScene("view/Start.fxml", "Book Management System");
	    }

	    @FXML
	    void btn_add_click(ActionEvent event) throws IOException {
	    	Start.changeScene("view/BookAdd.fxml", "Add New Book");
	    }

	    @FXML
	    void btn_edit_del_click(ActionEvent event) throws IOException {
	    	Start.changeScene("view/BookEdit.fxml", "Edit / Delete Book");
	    }

	    @FXML
	    void btn_search_click(ActionEvent event) throws IOException {
	    	Start.changeScene("view/BookSearch.fxml", "Search Book");
	    }

	    @FXML
	    void btn_view_click(ActionEvent event) throws IOException {
	    	Start.changeScene("view/BookView.fxml", "View Book");
	    }
}
