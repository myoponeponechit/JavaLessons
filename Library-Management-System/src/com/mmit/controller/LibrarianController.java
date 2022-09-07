package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Index;
import com.mmit.model.entity.DatabaseHandler;
import com.mmit.model.entity.Librarian;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class LibrarianController implements Initializable{
	
	@FXML
    private TableColumn<Librarian, String> col_email;

    @FXML
    private TableColumn<Librarian, Integer> col_id;

    @FXML
    private TableColumn<Librarian, String> col_nrc_no;

    @FXML
    private TableColumn<Librarian, String> col_password;

    @FXML
    private TableColumn<Librarian, String> col_phone_no;

    @FXML
    private TableView<Librarian> tbl_librarian;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_nrc_no;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_phone_no;
    
    private Librarian selected_lib = null;

    @FXML
    void back_click(MouseEvent event) throws IOException {
    	Index.changeScene("view/Menu.fxml", "Library Management System");
    }

    @FXML
    void btn_add_click(ActionEvent event) {
    	try {
    		var lib = new Librarian();
        	lib.setEmail(txt_email.getText());
        	lib.setNrcNo(txt_nrc_no.getText());
        	lib.setPassword(txt_password.getText());
        	lib.setPhone(txt_phone_no.getText());
        	
        	DatabaseHandler.addLibrarian(lib);
        	
        	showAlert(AlertType.INFORMATION, "Success");
        	clearData();
        	showLibrarian();
    	}
    	catch (Exception e) {
			showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    private void clearData() {
    	txt_email.setText(null);
    	txt_nrc_no.setText(null);
    	txt_password.setText(null);
    	txt_phone_no.setText(null);
	}

	private Optional<ButtonType> showAlert(AlertType type, String msg) {
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		return alert.showAndWait();
	}

	@FXML
    void btn_delete_click(ActionEvent event) {
		try {
			Optional<ButtonType> result = showAlert(AlertType.CONFIRMATION, "Are you sure want to delete?");
			if(result.get() == ButtonType.OK) {
				DatabaseHandler.deleteLibrarian(selected_lib);
				clearData();
				showLibrarian();
			}
		}
		catch (Exception e) {
			showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_logout_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btn_reset_click(ActionEvent event) {
    	clearData();
    }

    @FXML
    void btn_update_click(ActionEvent event) {
    	try {
        	selected_lib.setEmail(txt_email.getText());
        	selected_lib.setNrcNo(txt_nrc_no.getText());
        	selected_lib.setPassword(txt_password.getText());
        	selected_lib.setPhone(txt_phone_no.getText());
        	
        	DatabaseHandler.updateLibrarian(selected_lib);
        	showAlert(AlertType.INFORMATION, "Update success");
        	clearData();
        	showLibrarian();
    	}
    	catch (Exception e) {
			showAlert(AlertType.ERROR, e.getMessage());
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_nrc_no.setCellValueFactory(new PropertyValueFactory<>("nrcNo"));
		col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
		col_phone_no.setCellValueFactory(new PropertyValueFactory<>("phone"));
		
		showLibrarian();
		
		tbl_librarian.getSelectionModel().selectedItemProperty()
		.addListener(
				(obs, old_select, new_select) -> {
					selected_lib = tbl_librarian.getSelectionModel().getSelectedItem();
					txt_email.setText(selected_lib.getEmail());
					txt_nrc_no.setText(selected_lib.getNrcNo());
					txt_password.setText(selected_lib.getPassword());
					txt_phone_no.setText(selected_lib.getPhone());
				}
			);
		
		
	}

	private void showLibrarian() {
		
		List<Librarian> list = DatabaseHandler.findAllLibrarian();
		tbl_librarian.setItems(FXCollections.observableArrayList(list));
	}
}
