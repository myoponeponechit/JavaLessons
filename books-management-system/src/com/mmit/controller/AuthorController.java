package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.entity.Author;
import com.mmit.model.entity.Category;
import com.mmit.model.entity.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AuthorController implements Initializable{

	 @FXML
	    private TableColumn<Author, LocalDate> col_birthday;

	    @FXML
	    private TableColumn<Author, String> col_city;

	    @FXML
	    private TableColumn<Author, Integer> col_id;

	    @FXML
	    private TableColumn<Author, String> col_name;

	    @FXML
	    private TableView<Author> tbl_author;

	    @FXML
	    private DatePicker txt_birthday;

	    @FXML
	    private TextField txt_city;

	    @FXML
	    private TextField txt_name;
	    
	    private Author selected_author = null;

	    @FXML
	    void back_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Start.fxml", "Book Management System");
	    }

	    @FXML
	    void btn_add_click(ActionEvent event) {
	    	try {
	    		if(txt_birthday.getValue() == null) {
	    			showAlert(AlertType.ERROR, "Birthday is required!");
	    			return;
	    		}
	    		// create object
		    	var obj = new Author();
		    	// map value from textfield to obj's field
		    	obj.setBirthday(txt_birthday.getValue());
		    	obj.setCity(txt_city.getText());
		    	obj.setName(txt_name.getText());
		    	// save db
		    	DatabaseHandler.saveAuthor(obj);
		    	showAlert(AlertType.INFORMATION, "Success");
		    	resetData();
		    	// show data
		    	showData();
	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    private void resetData() {
			txt_birthday.setValue(null);
			txt_city.setText(null);
			txt_name.setText(null);
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
			if(showAlert(AlertType.CONFIRMATION, "Are you sure to delete?").get() == ButtonType.OK) {
				// deleteselected author
				DatabaseHandler.deleteAuthor(selected_author);
				// reset data
				resetData();
				// show data
				showData();
			}
	    }

	    @FXML
	    void btn_update_click(ActionEvent event) {
	    	try {
	    		// get old author obj from table
	    		selected_author.setBirthday(txt_birthday.getValue());
	    		selected_author.setCity(txt_city.getText());
	    		selected_author.setName(txt_name.getText());
		    	// save to db
		    	DatabaseHandler.updateAuthor(selected_author);
		    	// show alert
		    	showAlert(AlertType.INFORMATION, "Update success");
		    	// reset data
		    	resetData();
		    	// show data
		    	showData();
	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
			col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			
			showData();
			
			tbl_author.getSelectionModel().selectedItemProperty()
			.addListener(
					(obs, old_select, new_select) -> {
						selected_author = tbl_author.getSelectionModel().getSelectedItem();
						txt_birthday.setValue(selected_author.getBirthday());
						txt_city.setText(selected_author.getCity());
						txt_name.setText(selected_author.getName());
					}
					
				);
			
		}

		private void showData() {
			List<Author> list = DatabaseHandler.findAllAuthor();
			
			tbl_author.setItems(FXCollections.observableArrayList(list));
		}
}
