package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Index;
import com.mmit.model.entity.DatabaseHandler;
import com.mmit.model.entity.Member;

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

public class MemberController implements Initializable{
	
	 @FXML
	    private TableColumn<Member, String> col_academic_year;

	    @FXML
	    private TableColumn<Member, Integer> col_card_id;

	    @FXML
	    private TableColumn<Member, String> col_class_year;

	    @FXML
	    private TableColumn<Member, LocalDate> col_created_date;

	    @FXML
	    private TableColumn<Member, LocalDate> col_expired_date;

	    @FXML
	    private TableColumn<Member, String> col_name;

	    @FXML
	    private TableColumn<Member, String> col_roll_no;

	    @FXML
	    private TableView<Member> tbl_member;

	    @FXML
	    private TextField txt_academic_year;

	    @FXML
	    private TextField txt_class_year;

	    @FXML
	    private TextField txt_name;

	    @FXML
	    private TextField txt_roll_no;
	    
	    private Member selected_member;

	    @FXML
	    void back_click(MouseEvent event) throws IOException {
	    	Index.changeScene("view/Menu.fxml", "Library Management System");
	    }

	    @FXML
	    void btn_add_click(ActionEvent event) {
	    	try {
	    		if(txt_name.getText() == null) {
	    			showAlert(AlertType.ERROR, "Name is required");
	    			return;
	    		}
	    		if(txt_roll_no.getText() == null) {
	    			showAlert(AlertType.ERROR, "Roll no is required");
	    			return;
	    		}
	    		if(txt_class_year.getText() == null) {
	    			showAlert(AlertType.ERROR, "Class year is required");
	    			return;
	    		}
	    		if(txt_academic_year.getText() == null) {
	    			showAlert(AlertType.ERROR, "Academic year is required");
	    			return;
	    		}
	    		if(selected_member != null) {
	    			showAlert(AlertType.ERROR, "This member already exist");
	    			return;
	    		}
	    		var member = new Member();
		    	member.setAcademicYear(txt_academic_year.getText());
		    	member.setCreatedDate(LocalDate.now());
		    	
		    	var dd = LocalDate.now().getDayOfMonth();
		    	var mm = LocalDate.now().getMonthValue();
		    	var yyyy = LocalDate.now().getYear() + 1;
		    	var expDate = LocalDate.of(yyyy, mm, dd);
		    	member.setExpiredDate(expDate);
		    	
		    	member.setName(txt_name.getText());
		    	member.setRollNo(txt_roll_no.getText());
		    	member.setYear(txt_class_year.getText());
		    	
		    	DatabaseHandler.addMember(member);
		    	showAlert(AlertType.INFORMATION, "Success");
		    	clearData();
		    	showMember();
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
			return alert.showAndWait();
		}

		@FXML
	    void btn_delete_click(ActionEvent event) {
			try {
				Optional<ButtonType> result = showAlert(AlertType.CONFIRMATION, "Are you sure want to delete?");
				if(result.get() == ButtonType.OK) {
					DatabaseHandler.deleteMember(selected_member);
			    	clearData();
			    	showMember();
				}
			}
			catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }
	    private void clearData() {
	    	txt_academic_year.setText(null);
	    	txt_class_year.setText(null);
	    	txt_name.setText(null);
	    	txt_roll_no.setText(null);
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
	    		selected_member.setAcademicYear(txt_academic_year.getText());
	    		selected_member.setName(txt_name.getText());
	    		selected_member.setRollNo(txt_roll_no.getText());
	    		selected_member.setYear(txt_class_year.getText());
	    		DatabaseHandler.updateMember(selected_member);
		    	showAlert(AlertType.INFORMATION, "Update success");
		    	clearData();
		    	showMember();
	    	}
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_academic_year.setCellValueFactory(new PropertyValueFactory<>("academicYear"));
			col_card_id.setCellValueFactory(new PropertyValueFactory<>("cardId"));
			col_class_year.setCellValueFactory(new PropertyValueFactory<>("year"));
			col_created_date.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
			col_expired_date.setCellValueFactory(new PropertyValueFactory<>("expiredDate"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			col_roll_no.setCellValueFactory(new PropertyValueFactory<>("rollNo"));
			
			showMember();
			
			tbl_member.getSelectionModel().selectedItemProperty()
			.addListener(
						(obs, old_select, new_select) -> {
							selected_member = tbl_member.getSelectionModel().getSelectedItem();
							txt_academic_year.setText(selected_member.getAcademicYear());
							txt_class_year.setText(selected_member.getYear());
							txt_name.setText(selected_member.getName());
							txt_roll_no.setText(selected_member.getRollNo());
						}
					);
		}

		private void showMember() {
			List<Member> list = DatabaseHandler.findAllMember();
			tbl_member.setItems(FXCollections.observableArrayList(list));
		}
}
