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
public class AddCustomerController implements Initializable {

    @FXML
    private TextField text_CustomerID;
    @FXML
    private TextField text_Name;
    @FXML
    private TextField text_PhoneNo;
    @FXML
    private TextField text_Sex;
    @FXML
    private TextField text_Address;
    @FXML
    private TextField text_WorkerID;
    @FXML
    private Button btnAddCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionOnAddCustomerr(ActionEvent event) {
        try{
         if(!(text_CustomerID.getText().trim().isEmpty() ||
                 text_Name.getText().trim().isEmpty() ||  
                 text_Sex.getText().trim().isEmpty() || 
                 text_PhoneNo.getText().trim().isEmpty() ||
                 text_Address.getText().trim().isEmpty() ||
                 text_WorkerID.getText().trim().isEmpty()))
         {
            if(addIntoCustomer(text_CustomerID.getText(), text_Name.getText(),text_Sex.getText(), text_PhoneNo.getText(), text_Address.getText(), text_WorkerID.getText()))
            {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Customer");
                    alert.setContentText("Cusotmer has added");
                    alert.showAndWait();
                     Stage stage = (Stage) btnAddCustomer.getScene().getWindow();
                     stage.close();
            }
            else
            {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Customer");
                    alert.setContentText("Customer not added\nWorkerID must be of 4 figures and Unique\nFill up all the text fields appropriately.");
                    alert.showAndWait();
            }
         }
      else
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Customer");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();
        }
        }
        catch(Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Customer");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();              
        }
    }
    
    
    public boolean addIntoCustomer(String CustomerID, String name, String sex, String phoneNO,String Address, String WorkerID)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Customer (CustomerID , name, sex, PhoneNo, Address, WorkerID) VALUES ('%s','%s','%s','%s', '%s', '%s')",CustomerID, name , sex, phoneNO, Address, WorkerID));
			if(countUpdated > 0)
				return true;
			else return false;
		}
		catch(SQLException e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Customer");
                    alert.setContentText("Connection with Database Failed or\n"+e);
                    alert.showAndWait();
			return false;
		}
	}


}
