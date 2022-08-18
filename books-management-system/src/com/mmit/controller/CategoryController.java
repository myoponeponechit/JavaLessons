package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.entity.Category;
import com.mmit.model.entity.DatabaseHandler;

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

public class CategoryController implements Initializable{
	
	@FXML
    private TableColumn<Category, Integer> col_id;

    @FXML
    private TableColumn<Category, String> col_name;

    @FXML
    private TableView<Category> tbl_category;

    @FXML
    private TextField txt_name;

    @FXML
    void back_click(MouseEvent event) throws IOException {
    	Start.changeScene("view/Start.fxml", "Book Management System");
    }

    @FXML
    void btn_add_click(ActionEvent event) {
    	try {
    		var name = txt_name.getText();
        	if(name.isEmpty()) {
        		showAlert(AlertType.ERROR, "Category name is required!");
        		return;
        	}
        	DatabaseHandler.saveCategory(name);
        	showAlert(AlertType.INFORMATION, "Success");
        	txt_name.setText(null);
        	showCategory();
    	}
    	catch (Exception e) {
			showAlert(AlertType.ERROR, e.getMessage());
		}
    }
    private Optional<ButtonType> showAlert(AlertType type, String msg) {
    	Alert alert = new Alert(type);
    	alert.setContentText(msg);
    	alert.setHeaderText(null);
    	alert.setTitle("Message");
    	//alert.show();
    	return alert.showAndWait();
    }
    @FXML
    void btn_delete_click(ActionEvent event) {
    	try {
    		Optional<ButtonType> result = showAlert(AlertType.CONFIRMATION, "Are you sure to delete?");
        	if(result.get() == ButtonType.OK) {
        		// get selected category 
        		var category = tbl_category.getSelectionModel().getSelectedItem();
        		txt_name.setText(null);
        		// delete
        		DatabaseHandler.deleteCategory(category.getId());
        		// show category list
        		showCategory();
        	}
    	}
    	catch (Exception e) {
			showAlert(AlertType.ERROR, e.getMessage());
		}
    }

    @FXML
    void btn_update_click(ActionEvent event) {
    	try {
    		// get new category name
        	var new_name = txt_name.getText();
        	// get old category obj(id, name) (1, Category One)
        	var category = tbl_category.getSelectionModel().getSelectedItem();
        	category.setName(new_name); // (1, Category 1)
        	DatabaseHandler.updateCategory(category);
        	showAlert(AlertType.INFORMATION, "Update Success");
        	txt_name.setText(null);
        	showCategory();
    	}
    	catch (Exception e) {
			showAlert(AlertType.ERROR, e.getMessage());
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// getVariable()
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		showCategory();
		
		tbl_category.getSelectionModel().selectedItemProperty()
		.addListener(
				(obs, old_select, new_select) -> {
					if(new_select != null) {
						var category = tbl_category.getSelectionModel().getSelectedItem();
						txt_name.setText(category.getName());
					}
				}
			);
	}

	private void showCategory() {
		
		List<Category> list = DatabaseHandler.findAllCategory();
		tbl_category.setItems(FXCollections.observableArrayList(list));
	}
}
