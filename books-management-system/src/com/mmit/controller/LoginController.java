package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;
import com.mmit.model.entity.DatabaseHandler;
import com.mmit.model.entity.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {
	
	 @FXML
	    private TextField txt_email;

	    @FXML
	    private PasswordField txt_password;
	    
	    @FXML
	    void btn_login_click(ActionEvent event) throws IOException {
	    	var email = txt_email.getText();
	    	var pass = txt_password.getText();
	    	
	    	if(email.isEmpty()) {
	    		showAlert(AlertType.ERROR, "Email is required!");
	    		return;
	    	}
	    	if(pass.isEmpty()) {
	    		showAlert(AlertType.ERROR, "Password is required!");
	    		return;
	    	}
	    	// authentication
	    	var user = DatabaseHandler.login(email, pass);
	    	if(user == null) {
	    		showAlert(AlertType.ERROR, "Authentication fail");
	    	}
	    	else {
	    		Start.login_user = user;
	    		Start.changeScene("view/Start.fxml", "Book Management System");
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
			txt_email.setText(null);
	    	txt_password.setText(null);
	    }

	    @FXML
	    void close_click(MouseEvent event) {
	    	System.exit(0);
	    }

}
