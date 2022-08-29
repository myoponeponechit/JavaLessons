package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.mmit.Index;
import com.mmit.model.entity.DatabaseHandler;
import com.mmit.model.entity.Transaction;
import com.mmit.model.entity.Transaction;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BorrowBooksController implements Initializable{
	
	 @FXML
	    private TableColumn<Transaction, Integer> col_book_id;

	    @FXML
	    private TableColumn<Transaction, LocalDate> col_borrow_date;

	    @FXML
	    private TableColumn<Transaction, Integer> col_card_id;

	    @FXML
	    private TableColumn<Transaction, LocalDate> col_duedate;

	    @FXML
	    private TableColumn<Transaction, Integer> col_id;

	    @FXML
	    private TableColumn<Transaction, String> col_librarian;

	    @FXML
	    private TableView<Transaction> tbl_borrrow;

	    @FXML
	    private TextField txt_book_code;

	    @FXML
	    private TextField txt_card_id;

	    @FXML
	    void back_click(MouseEvent event) throws IOException {
	    	Index.changeScene("view/Menu.fxml", "Library Management System");
	    }

	    @FXML
	    void btn_borrow_click(ActionEvent event) {
	    	try {
	    		var bookCode = txt_book_code.getText();
		    	var cardId = txt_card_id.getText();
		    	DatabaseHandler.borrowBook(bookCode, cardId);
		    	txt_book_code.setText(null);
		    	txt_card_id.setText(null);
		    	showTransaction();
	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    private void showAlert(AlertType type, String msg) {
			Alert alert = new Alert(type);
			alert.setContentText(msg);
			alert.setHeaderText(null);
			alert.setTitle("Message");
			alert.show();
		}

		@FXML
	    void btn_cancel_click(ActionEvent event) {
	    	txt_book_code.setText(null);
	    	txt_card_id.setText(null);
	    }

	    @FXML
	    void btn_logout_click(ActionEvent event) {
	    	System.exit(0);
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_book_id.setCellValueFactory(new PropertyValueFactory<>("bookCode"));
			col_borrow_date.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
			col_card_id.setCellValueFactory(new PropertyValueFactory<>("cardId"));
			col_duedate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_librarian.setCellValueFactory(new PropertyValueFactory<>("entryBy"));
			
			showTransaction();
		}

		private void showTransaction() {
			List<Transaction> list = DatabaseHandler.findAllTransaction();
			tbl_borrrow.setItems(FXCollections.observableArrayList(list));
		}
}
