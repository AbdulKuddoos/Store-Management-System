/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sqlconnectivity.ConnectDB;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class AddReportsController implements Initializable {


    @FXML
    private TextField text_ReportID;
    @FXML
    private TextField text_ReportType;
    @FXML
    private TextField text_StaffID;
    @FXML
    private TextField text_Date;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionOnAddReport(ActionEvent event) {
         if(!(text_ReportID.getText().trim().isEmpty() 
                 || text_ReportType.getText().trim().isEmpty() 
                 || text_Date.getText().trim().isEmpty() 
                 || text_StaffID.getText().trim().isEmpty()))
        {
        if(addReport(text_ReportID.getText(), text_ReportType.getText(),text_Date.getText(), text_StaffID.getText()))
        {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Add Report");
                    alert.setContentText("Report has been added");
                    alert.showAndWait();
                     Stage stage = (Stage) btnAdd.getScene().getWindow();
                     stage.close();
        }
        else
        {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Report");
                    alert.setContentText("Report not added\nReportID must be of 4 figures and Unique"
                            + "\nFill up all the text fields appropriately\nSupplierID must be regiserted.");
                    alert.showAndWait();
        }
    }
      else
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Add Report");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();
        }
    }
    
        
    public boolean addReport(String ReportID, String reportType, String date, String StaffID)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Report (ReportID , Type, ReportingDate, StaffID) VALUES ('%s','%s','%s','%s')",
                                ReportID, reportType , date, StaffID));
			if(countUpdated > 0)
				return true;
			else return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}
    
}
