package com.mmit.controller;

import java.io.IOException;

import com.mmit.Index;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MenuController {
	
	@FXML
    void author_click(MouseEvent event) throws IOException {
		Index.changeScene("view/Author.fxml", "Author");
    }

    @FXML
    void back_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/Index.fxml", "Library Management System.Login");
    }

    @FXML
    void book_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/Book.fxml", "Book Information");
    }

    @FXML
    void borrow_book_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/BorrowBooks.fxml", "Borrow Books");
    }
    
    @FXML
    void return_book_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/ReturnBooks.fxml", "Return Books");
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void category_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/Category.fxml", "Categories");
    }

    @FXML
    void librarian_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/Librarian.fxml", "Librarians");
    }

    @FXML
    void member_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/Member.fxml", "Members");
    }
}
