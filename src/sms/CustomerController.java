/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.io.IOException;
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
public class CustomerController implements Initializable {

    @FXML
    private TableView<Customers> CustomerTable;
    @FXML
    private TableColumn<Customers, String> colCustomerID;
    @FXML
    private TableColumn<Customers, String> colName;
    @FXML
    private TableColumn<Customers, String> colSex;
    @FXML
    private TableColumn<Customers, String> colPhoneNo;
    @FXML
    private TableColumn<Customers, String> colAddress;
    @FXML
    private TableColumn<Customers, String> colWorkerID;
    @FXML
    private Button btnAddCustomer;
    @FXML
    private Button btnViewCustomer1;
    @FXML
    private Pane statusPane;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusAddress_lbl;
    
    
    static ObservableList<Customers> CustomerList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionOnAddCustomer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCustomer.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Add Product");
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void actionOnViewCustomer(ActionEvent event) {
        
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colSex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colWorkerID.setCellValueFactory(new PropertyValueFactory<>("WorkerID"));
        
        
        getCustomerTable();
        CustomerTable.setItems(CustomerList);
        
    }
    
    public static void getCustomerTable()
    {
        try{
        Connection connection;
            connection = ConnectDB.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("exec SelectAllCustomers");
        
        while(rs.next())
        {
            CustomerList.add(
                    new Customers(rs.getString("CustomerID"), rs.getString("Name"), rs.getString("Sex"),
                    rs.getString("PhoneNo"), rs.getString("Address"), rs.getString("WorkerID")));
      
        }
        
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    
}
