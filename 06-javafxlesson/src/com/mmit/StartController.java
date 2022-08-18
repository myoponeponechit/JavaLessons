package com.mmit;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class StartController {
	 @FXML
	    private TextField txtEmail;

	    @FXML
	    private PasswordField txtPassword;

	    @FXML
	    void btnClear_click(ActionEvent event) {
	    	txtEmail.setText("");
	    	txtPassword.setText(null);
	    }

	    @FXML
	    void btnLogin_click(ActionEvent event) {
	    	String email = txtEmail.getText();
	    	String pass = txtPassword.getText();
	    	
	    	if(email.equals("admin@gmail.com") && pass.equals("admin")) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setContentText("Login success");
	    		alert.setHeaderText("Message");
	    		alert.show();
	    	}
	    	else {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setContentText("Incorrect email and password");
	    		alert.setHeaderText("Error Message");
	    		alert.show();
	    	}
	    }
	    

	    @FXML
	    void lblRegister_click(MouseEvent event) throws IOException {
	    	Main.changeScene("Register.fxml");
	    }
}
