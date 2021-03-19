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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sqlconnectivity.ConnectDB;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class AddProductController implements Initializable {

    @FXML
    private TextField text_ProductID;
    @FXML
    private TextField text_Name;
    @FXML
    private TextField text_Size;
    @FXML
    private TextField text_Price;
    @FXML
    private TextField text_Manufacturer;
    @FXML
    private TextField text_StockID;
    @FXML
    private ComboBox categoryChoiceBox;
    @FXML
    private TextField text_Qty;
    @FXML
    private Button btnAddProduct;
    
     private final ObservableList<String> positionValues = FXCollections.observableArrayList("Food", "Crockery", "Cosmetics");

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        categoryChoiceBox.setValue("Food");
        categoryChoiceBox.setItems(positionValues);
    }    

        public boolean addIntoProduct(String ProductID, String name, String category,int price, String size,String manufacturer)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Product (ProductID , name, category, Price, size, manufacturer) VALUES ('%s','%s','%s','%d', '%s', '%s')",ProductID, name , category, price, size, manufacturer));
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
        
        public boolean addIntoStock(String StockID, int qty, String productID)
	{
		try {
                        Connection con = ConnectDB.getConnection();
			Statement stmt=con.createStatement();  
			int countUpdated = stmt.executeUpdate(String.format("INSERT INTO Stock (stockID , qty, productID) VALUES ('%s','%d','%s')",StockID, qty, productID));
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
    private void actionOnAddProduct(ActionEvent event) {
         if(!(text_ProductID.getText().trim().isEmpty()
                 || text_Name.getText().trim().isEmpty()
                 || categoryChoiceBox.getValue().toString().trim().isEmpty()
                 || text_Price.getText().trim().isEmpty()))
        {
            if(addIntoProduct(text_ProductID.getText(), text_Name.getText(),categoryChoiceBox.getValue().toString(), new Integer(text_Price.getText()), text_Size.getText(), text_Manufacturer.getText())
                && addIntoStock(text_StockID.getText(), new Integer(text_Qty.getText()), text_ProductID.getText()))
            {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("Product and Stock");
                    alert.setContentText("Product has been added");
                    alert.showAndWait();
                     Stage stage = (Stage) btnAddProduct.getScene().getWindow();
                     stage.close();
            }
            else
            {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Product and Stock");
                    alert.setContentText("Product not added\nProductID or StockID must be of 4 figures\nFill up all the text fields appropriately.");
                    alert.showAndWait();
            }
        }
        else
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("Product and Stock");
                    alert.setContentText("Fill up all the text fields appropriately.");
                    alert.showAndWait();
        }
    }
}
   
