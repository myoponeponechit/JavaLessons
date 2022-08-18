package com.mmit;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class RegisterController implements Initializable{
	
	@FXML
    private ComboBox<String> cbo_city;

    @FXML
    private CheckBox chk_java;

    @FXML
    private CheckBox chk_javascript;

    @FXML
    private CheckBox chk_php;

    @FXML
    private ToggleGroup radio_gender;

    @FXML
    private DatePicker txt_birthday;

    @FXML
    private TextField txt_email;

    @FXML
    private TextArea txt_other;

    @FXML
    private PasswordField txt_password;

    @FXML
    void btn_register_click(ActionEvent event) {
    	String email = txt_email.getText();
    	String pass = txt_password.getText();
    	String city = cbo_city.getSelectionModel().getSelectedItem();
    	LocalDate dob = txt_birthday.getValue();
    	String other_info = txt_other.getText();
    	RadioButton selectRadio = (RadioButton) radio_gender.getSelectedToggle();
    	String gender = selectRadio.getText();
    	String skillset = "";
    	if(chk_java.isSelected()) {
    		skillset += chk_java.getText() + ", ";
    	}
    	if(chk_php.isSelected()) {
    		skillset += chk_php.getText() + ", ";
    	}
    	if(chk_javascript.isSelected()) {
    		skillset += chk_javascript.getText() + ", ";
    	}
    	skillset = skillset.substring(0, skillset.lastIndexOf(","));
    	
    	System.out.println("---- Profile Data ----");
    	System.out.println("Email: " + email);
    	System.out.println("Password: " + pass);
    	System.out.println("City: " + city);
    	System.out.println("Birthday: " + dob);
    	System.out.println("Gender: " + gender);
    	System.out.println("Other Info: " + other_info);
    	System.out.println("Skillsets: " + skillset);
    }

    @FXML
    void btn_reset_click(ActionEvent event) {

    }

    @FXML
    void lblLogin_click(MouseEvent event) throws IOException {
    	Main.changeScene("Start.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		List<String> cities = List.of("Yangon", "Mandalay", "Pyin Oo Lwin");
		cbo_city.setItems(FXCollections.observableArrayList(cities));
	}
    
}
