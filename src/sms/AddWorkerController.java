/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.math.BigDecimal;
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
public class AddWorkerController implements Initializable {

    @FXML
    private TextField text_WorkerID;
    @FXML
    private TextField text_Name;
    @FXML
    private TextField text_PhoneNo;
    @FXML
    private TextField text_Sex;
    @FXML
    private TextField text_Address;
    @FXML
    private TextField text_Salary;
    @FXML
    private Button btnAddWorker;
    @FXML
    private TextField text_CustomerID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void actionOnAddWorker(ActionEvent event) {
        try{
         if(!(text_WorkerID.getText().trim().isEmpty() ||
                 text_Name.getText().trim().isEmpty() ||  
                 text_Sex.getText().trim().isEmpty() || 
                 text_PhoneNo.getText().trim().isEmpty() ||
                 text_Address.getText().trim().isEmpty() ||
                 text_Salary.getText().trim().isEmpty()))
         {
            if(addIntoWorker(text_WorkerID.getText(), text_Name.getText(),text_Sex.getText(), text_PhoneNo.getText(), text_Address.getText(), new Double(text_Salary.getText())))
            {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Worker");
                    alert.setContentText("Worker has added");
                    alert.showAndWait();
                     Stage stage = (Stage) btnAddWorker.getScene().getWindow();
                     stage.close();
            }
            else
            {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Worker");
                    alert.setContentText("Worker not added\nWorkerID must be of 4 figures\nFill up all the text fields appropriately.");
                    alert.showAndWait();
            }
         }
      else
        {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Worker");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();
        }
        }
        catch(Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Worker");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();              
        }
              
        
    }
        
    
    @FXML
    public boolean addIntoWorker(String WorkerID, String name, String sex, String phoneNO,String Address, Double salary)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Worker (WorkerID , name, sex, PhoneNo, Address, salary) VALUES ('%s','%s','%s','%s', '%s', '%f')",WorkerID, name , sex, phoneNO, Address, salary));
			if(countUpdated > 0)
				return true;
			else 
                            return false;
		}
		catch(SQLException e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Worker");
                    alert.setContentText("Connection with Database Failed or\n"+e);
                    alert.showAndWait();
			return false;
		}
	}

    
}
