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
public class AddSupplierController implements Initializable {

    @FXML
    private TextField signup_SupplierID;
    @FXML
    private TextField signup_Name;
    @FXML
    private TextField signup_PhoneNo;
    @FXML
    private TextField signUp_Email;
    @FXML
    private Button btn_AddSupplier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    
    
    public boolean signUp(String SupplierID, String name, String email, String PhoneNo)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Supplier (SupplierID , name, email, phoneNo) VALUES ('%s','%s','%s','%s')",SupplierID, name , email, PhoneNo));
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

    @FXML
    private void clickAddSuppliers(ActionEvent event) {
        if(!(signup_SupplierID.getText().trim().isEmpty() || signup_Name.getText().trim().isEmpty() || signUp_Email.getText().trim().isEmpty() || signup_PhoneNo.getText().trim().isEmpty()))
        {
        if(signUp(signup_SupplierID.getText(), signup_Name.getText(),signUp_Email.getText(), signup_PhoneNo.getText()))
        {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Supplier");
                    alert.setContentText("Supplier has been added");
                    alert.showAndWait();
                     Stage stage = (Stage) btn_AddSupplier.getScene().getWindow();
                     stage.close();
        }
        else
        {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Supplier");
                    alert.setContentText("Supplier not added\nSupplierID must be of 4 figures\nFill up all the text fields appropriately.");
                    alert.showAndWait();
        }
    }
      else
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Supplier");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();
        }
    }
    
}
