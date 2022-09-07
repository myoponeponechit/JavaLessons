package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Index;
import com.mmit.model.entity.Author;
import com.mmit.model.entity.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	    	Index.changeScene("view/Menu.fxml", "Library Management System");
	    }

	    @FXML
	    void btn_add_click(ActionEvent event) {
	    	if(txt_birthday.getValue() == null) {
	    		showAlert(AlertType.ERROR, "Birthday is required.");
	    		return;
	    	}
	    	try {
	    		var auth = new Author();
		    	auth.setBirthday(txt_birthday.getValue());
		    	auth.setCity(txt_city.getText());
		    	auth.setName(txt_name.getText());
		    	DatabaseHandler.addAuthor(auth);
		    	showAlert(AlertType.INFORMATION, "Success");
		    	clearData();
		    	showAuthor();
	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    private void clearData() {
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
			try {
				Optional<ButtonType> result = showAlert(AlertType.CONFIRMATION, "Are you sure want to delete?");
				if(result.get() == ButtonType.OK) {
					DatabaseHandler.deleteAuthor(selected_author);
					clearData();
					showAuthor();
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
	    void btn_update_click(ActionEvent event) {
	    	try {
	    		selected_author.setBirthday(txt_birthday.getValue());
		    	selected_author.setCity(txt_city.getText());
		    	selected_author.setName(txt_name.getText());
		    	
		    	DatabaseHandler.updateAuthor(selected_author);
		    	showAlert(AlertType.INFORMATION, "Update success");
		    	clearData();
		    	showAuthor();
	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }
	    
	    @FXML
	    void btn_reset_click(ActionEvent event) {
	    	clearData();
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
			col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			
			showAuthor();
			
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

		private void showAuthor() {
			List<Author> list = DatabaseHandler.findAllAuthor();
					
			tbl_author.setItems(FXCollections.observableArrayList(list));
		}
}
