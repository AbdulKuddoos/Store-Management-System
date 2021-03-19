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
public class AddPurchasesController implements Initializable {

    @FXML
    private TextField text_PurchaseID;
    @FXML
    private TextField text_PurchasingCost;
    @FXML
    private TextField text_SupplierID;
    @FXML
    private TextField text_StaffID;
    @FXML
    private TextField text_Date;
    @FXML
    private Button btnAddPurchase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public boolean addIntoPurchase(String PurchaseID, int purchasingCost, String date, String StaffID, String SupplierID)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Purchase (PurchaseID , PurchasingCost, date, StaffID, SupplierID) "
                                + "VALUES ('%s','%d','%s','%s', '%s')",PurchaseID, purchasingCost , date, StaffID, SupplierID));
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
    private void actionOnAddPurchase(ActionEvent event) {
        try{
     if(!(text_PurchaseID.getText().trim().isEmpty()
             || text_PurchasingCost.getText().trim().isEmpty()
             || text_Date.getText().trim().isEmpty()
             || text_StaffID.getText().trim().isEmpty()
             || text_SupplierID.getText().trim().isEmpty() ))
        {
        if(addIntoPurchase(text_PurchaseID.getText(),new Integer( text_PurchasingCost.getText()), text_Date.getText(), text_StaffID.getText(), text_SupplierID.getText()))
        {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Purchase");
                    alert.setContentText("Purchase Details has been added");
                    alert.showAndWait();
                     Stage stage = (Stage) btnAddPurchase.getScene().getWindow();
                     stage.close();
        }
        else
        {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Purchase");
                    alert.setContentText("Purchase not added\nProductID must be of 4 figures\nFill up all the text fields appropriately.");
                    alert.showAndWait();
        }
    }
      else
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Purchase");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();
        }
        }
        catch(Exception e)
        {System.out.println(e);}
    }
}
