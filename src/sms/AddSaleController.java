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
public class AddSaleController implements Initializable {

    @FXML
    private TextField billID;
    @FXML
    private TextField qty;
    @FXML
    private TextField customerID;
    @FXML
    private TextField ProductID;
    @FXML
    private TextField staffID;
    @FXML
    private Button btnAdd;
    
    long millis=System.currentTimeMillis();  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
     public boolean addIntoSales(String ID,String customerID, String staffID, String productID, int qty)
	{
            
        java.sql.Date date=new java.sql.Date(millis); 
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Bill "
                                + "(billID , CustomerID, StaffID, ProductID, Qty, Date) "
                                + "VALUES ('%s','%s','%s', '%s', '%d', '%s')",
                                ID, customerID , staffID, productID, qty, date));
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
     public boolean updateStock(int qty, String productID)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("Update Stock set qty = qty - '%d' "
                                + "where Stock.productID = '%s'", qty, productID));
			if(countUpdated > 0)
				return true;
			else return false;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
     

    @FXML
    private void actionOnAdd(ActionEvent event) {
        if(!(billID.getText().trim().isEmpty()
                 || qty.getText().trim().isEmpty()
                || customerID.getText().trim().isEmpty()
                || ProductID.getText().trim().isEmpty()
                || staffID.getText().trim().isEmpty()))
        {
            if(updateStock(new Integer(qty.getText()), ProductID.getText())){
                if(addIntoSales(billID.getText(), customerID.getText(), staffID.getText(), ProductID.getText(), 
                        new Integer(qty.getText())))
                {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setTitle("Confirmation");
                        alert.setHeaderText("Bill");
                        alert.setContentText("Bill record has been added");
                        alert.showAndWait();
                         Stage stage = (Stage) btnAdd.getScene().getWindow();
                         stage.close();
                }
                else
                {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setTitle("Restriction");
                        alert.setHeaderText("Stock");
                        alert.setContentText("Qty ro buy must be greater than zero\nProductID, StaffID and CustomerID must be of 4 figures and registered\nFill up all the text fields appropriately.");
                        alert.showAndWait();
                }
            }
            else
            {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Quantity of the Product is not appropriate.");
                    alert.setContentText("Please Enter Appropriate Quantity");
                    alert.showAndWait();
            }
        }
        else
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Bill");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();
        }
}
    
    
}
