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
import javafx.stage.Stage;;
import sqlconnectivity.ConnectDB;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class WorkersController implements Initializable {

    @FXML
    private Pane statusPane;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusAddress_lbl;
    @FXML
    private TableView<Worker> WorkerTable;
    @FXML
    private TableColumn<Worker, String> colWorkerID;
    @FXML
    private TableColumn<Worker, String> colName;
    @FXML
    private TableColumn<Worker, String> colSex;
    @FXML
    private TableColumn<Worker, String> colPhoneNo;
    @FXML
    private TableColumn<Worker, String> colAddress;
    @FXML
    private TableColumn<Worker, String> colSalary;
    @FXML
    private Button btnAddWorkers;
    @FXML
    private Button btnViewWorker;
    
    static ObservableList<Worker> WorkerList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionOnAddWorkers(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddWorker.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Add Worker");
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void actionOnViewWorkers(ActionEvent event) {
        colWorkerID.setCellValueFactory(new PropertyValueFactory<>("WorkerID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colSex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        
        getWorkerTable();
        WorkerTable.setItems(WorkerList);
        
    }
    
    public static void getWorkerTable()
    {
        try{
        Connection connection;
            connection = ConnectDB.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("Select * from Worker");
        
        while(rs.next())
        {
            WorkerList.add(
                    new Worker(rs.getString("WorkerID"), rs.getString("Name"), rs.getString("Sex"),
                    rs.getString("PhoneNo"), rs.getString("Address"), new BigDecimal(rs.getString("Salary"))));
      
        }
        
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
