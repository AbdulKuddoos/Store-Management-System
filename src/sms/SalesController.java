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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static sms.ProductsController.ProductList;
import sqlconnectivity.ConnectDB;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class SalesController implements Initializable {

    @FXML
    private Pane statusPane;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusAddress_lbl;
    @FXML
    private TableColumn<Sale, String> serialNo;
    @FXML
    private TableColumn<Sale, String> billID;
    @FXML
    private TableColumn<Sale, String> customerID;
    @FXML
    private TableColumn<Sale, String> staffID;
    @FXML
    private TableColumn<Sale, String> productID;
    @FXML
    private TableColumn<Sale, String> qty;
    @FXML
    private TableColumn<Sale, String> date;
    @FXML
    private TableColumn<Sale, String> name;
    @FXML
    private TableColumn<Sale, String> unitPrice;
    
    static ObservableList<Sale> SaleList = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Sale> customSaleTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionOnAddSale(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddSale.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Add Sale");
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void actionOnViewDetails(ActionEvent event) {
        serialNo.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        billID.setCellValueFactory(new PropertyValueFactory<>("billID"));
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        staffID.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        getCustomTable();
        customSaleTable.setItems(SaleList);
        
        
    }
    
    public void getCustomTable()
    {
     try{
        Connection connection;
            connection = ConnectDB.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("select * from [Sale Details]");
        
        while(rs.next())
        {
            SaleList.add(
                    new Sale(rs.getString("SerialNo"), rs.getString("billID"), rs.getString("CustomerID"),
                             rs.getString("StaffID"),rs.getString("ProductID"),rs.getString("qty"), rs.getString("Date"),
                             rs.getString("name"), rs.getString("price")));
        }
        
        }catch(NumberFormatException | SQLException e)
        {
            System.out.println(e + "Exception is here");
        }   
    }
    
}
