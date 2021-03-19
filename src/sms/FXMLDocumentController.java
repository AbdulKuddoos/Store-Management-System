/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sqlconnectivity.ConnectDB;

/**
 *
 * @author Abdul Quddoos
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TableView<Staff> Staff_Table;
    @FXML
    private TableColumn<Staff, String> Col_staffID;
    @FXML
    private TableColumn<Staff, String> Col_Name;
    @FXML
    private TableColumn<Staff, String> Col_UserName;
    @FXML
    private TableColumn<Staff, String> Col_password;
    @FXML
    private TableColumn<Staff, String> Col_Position;
    @FXML
    private TableColumn<Staff, String> Col_Email;
    @FXML
    private TableColumn<Staff, String> Col_Address;
    
    static ObservableList<Staff> staffList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Staff, String> Col_PhoneNo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Col_staffID.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
        Col_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Col_UserName.setCellValueFactory(new PropertyValueFactory<>("Username"));
        Col_password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        Col_Position.setCellValueFactory(new PropertyValueFactory<>("Position"));
        Col_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Col_Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Col_PhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
        
        getStaffTable();
        
        Staff_Table.setItems(staffList);
    }    
    
    public static void getStaffTable()
    {
        try{
        Connection connection;
            connection = ConnectDB.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("Select * from Staff");
        
        while(rs.next())
        {
            staffList.add(
                    new Staff(rs.getString("StaffID"), rs.getString("Name"), rs.getString("Username"),
                    rs.getString("Password"), rs.getString("Position"), rs.getString("Email"), rs.getString("Address"),
                    rs.getString("PhoneNo")));
      
        }
        
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    
}
