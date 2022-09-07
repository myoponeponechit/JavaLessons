package com.mmit.controller;

import java.io.IOException;

import com.mmit.Index;
import com.mmit.model.entity.DatabaseHandler;
import com.mmit.model.entity.Librarian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IndexController {
		@FXML
		private TextField txt_email;

		@FXML
		private PasswordField txt_pass;

	    @FXML
	    void btn_cancel_click(ActionEvent event) {
	    	txt_email.setText(null);
	    	txt_pass.setText(null);
	    }

	    @FXML
	    void btn_login_click(ActionEvent event) throws IOException {
	    	
	    		var email = txt_email.getText();
		    	var pass = txt_pass.getText();
		    	
		    	if(email.isEmpty()) {
		    		showAlert(AlertType.ERROR, "Email is required!");
		    		return;
		    	}
		    	if(pass.isEmpty()) {
		    		showAlert(AlertType.ERROR, "Password is required!");
		    		return;
		    	}
		    	
		    	// authentication
		    	Librarian lib = DatabaseHandler.login(email, pass);
		    	if(lib == null) {
		    		showAlert(AlertType.ERROR, "Authentication fail");
		    	}
		    	else {
		    		Index.login_user =  lib;
		    		Index.changeScene("view/Menu.fxml", "Library Management System");
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
}
