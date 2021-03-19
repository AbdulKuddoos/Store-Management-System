/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sqlconnectivity.ConnectDB;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class PurchasesController implements Initializable {

    @FXML
    private Pane statusPane;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusAddress_lbl;
    @FXML
    private Button btnAddSupplier;
    @FXML
    private Button btnAddPurchase;
    @FXML
    private TableView<Purchase> DetailsTables;
    @FXML
    private TableColumn<Purchase, String> colName;
    @FXML
    private TableColumn<Purchase, String> colEmail;
    @FXML
    private TableColumn<Purchase, String> colPhoneNo;
    @FXML
    private Button btnViewDetails;
    @FXML
    private TableColumn<Purchase, String> colPurchaseID;
    @FXML
    private TableColumn<Purchase, String> colPurchasingCost;
    @FXML
    private TableColumn<Purchase, String> colPurchasingDate;
    @FXML
    private TableColumn<Purchase, String> colStaffID;
    @FXML
    private TableColumn<Purchase, String> colSupplierID;

    
    static ObservableList<Purchase> DetailsList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickAddSupplier(ActionEvent event) {
        try
                        {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addSupplier.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));  
                            stage.setTitle("Add Supplier");
                            stage.show();
                        }
                        catch(IOException e)
                        {
                            System.out.println(e);
                        }
    }

    @FXML
    private void actionOnAddPurchases(ActionEvent event) {
    try
                        {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPurchases.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));  
                            stage.setTitle("Add Purchases");
                            stage.show();
                        }
                        catch(IOException e)
                        {
                            System.out.println(e);
                        }
    }

    @FXML
    private void actionOnViewDetails(ActionEvent event) {
        
        for ( int i = 0; i<DetailsTables.getItems().size(); i++) {
            DetailsTables.getItems().clear();
        }
        
        colPurchaseID.setCellValueFactory(new PropertyValueFactory<>("PurchaseID"));
        colPurchasingCost.setCellValueFactory(new PropertyValueFactory<>("PurchasingCost"));
        colPurchasingDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colStaffID.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
        colSupplierID.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
        
        getDetailsTable();
        
        DetailsTables.setItems(DetailsList);
        
    }
    
     public static void getDetailsTable()
    {
        try{
        Connection connection;
            connection = ConnectDB.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("");
        
        while(rs.next())
        {
            DetailsList.add(
                    new Purchase(rs.getString("PurchaseID"), new BigDecimal(rs.getString("PurchasingCost")), 
                            rs.getString("date"), rs.getString("StaffID"), 
                            rs.getString("SupplierID"), rs.getString("name"), 
                            rs.getString("email"), rs.getString("PhoneNo")));
        }
        
        }catch(NumberFormatException | SQLException e)
        {
            System.out.println(e);
        }
    }
    
    
}
