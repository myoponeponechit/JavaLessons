package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.mmit.Index;
import com.mmit.model.entity.DatabaseHandler;
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

public class ReturnBooksController implements Initializable{
	
	@FXML
    private TableColumn<Transaction, LocalDate> col_borrow_date;

    @FXML
    private TableColumn<Transaction, Integer> col_code;

    @FXML
    private TableColumn<Transaction, LocalDate> col_due_date;

    @FXML
    private TableColumn<Transaction, Double> col_fees;

    @FXML
    private TableColumn<Transaction, String> col_title;

    @FXML
    private TableView<Transaction> tbl_borrowbook;

    @FXML
    private TextField txt_book_code;

    @FXML
    private TextField txt_card_id;
    
    private Transaction selected_tran;

    @FXML
    void back_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/Menu.fxml", "Library Management System");
    }

    @FXML
    void btn_cancel_click(ActionEvent event) {
    	txt_book_code.setText(null);
    }

    @FXML
    void btn_check_click(ActionEvent event) {
    	try {
    		var card = txt_card_id.getText();
    		if(card == null || card.isEmpty()) {
    			showAlert(AlertType.ERROR, "Card id is required");
    			return;
    		}
        	List<Transaction> list = DatabaseHandler.checkCard(Integer.parseInt(card));
        	tbl_borrowbook.setItems(FXCollections.observableArrayList(list));
    	}
    	catch (Exception e) {
			e.printStackTrace();
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
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btn_return_click(ActionEvent event) {
    	try {
    		if(txt_card_id.getText() == null || txt_card_id.getText().isEmpty()) {
    			showAlert(AlertType.ERROR, "Card id is required");
    			return;
    		}
        	if(txt_book_code.getText() == null || txt_book_code.getText().isEmpty()) {
    			showAlert(AlertType.ERROR, "Book code is required");
    			return;
    		}
    		var code = selected_tran.getBookCode();
        	var cardId = selected_tran.getCardId();
        	
        	DatabaseHandler.returnBook(code, cardId);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_borrow_date.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
		col_code.setCellValueFactory(new PropertyValueFactory<>("bookCode"));
		col_due_date.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
		
		tbl_borrowbook.getSelectionModel().selectedItemProperty()
		.addListener(
					(obs, old_select, new_select) -> {
						selected_tran = tbl_borrowbook.getSelectionModel().getSelectedItem();
						txt_book_code.setText(String.valueOf(selected_tran.getBookCode()));
					}
				);
	}
}
