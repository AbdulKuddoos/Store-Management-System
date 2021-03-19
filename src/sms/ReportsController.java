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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sqlconnectivity.ConnectDB;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class ReportsController implements Initializable {

    @FXML
    private TableView<Report1> tableReport;
    @FXML
    private TableColumn<Report1, String> colReportID;
    @FXML
    private TableColumn<Report1, String> colType;
    @FXML
    private TableColumn<Report1, String> colDate;
    @FXML
    private TableColumn<Report1, String> colStaffID;
    @FXML
    private Button btnAddReport;
    @FXML
    private Button btnViewDetails;
    
    
    static ObservableList<Report1> ReportList = FXCollections.observableArrayList();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionOnAddReports(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddReports.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Add Report");
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void actionOnViewDetails(ActionEvent event) {
        getReportTable();
        tableReport.setItems(ReportList);
        
        colReportID.setCellValueFactory(new PropertyValueFactory<>("ReportID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("reportingDate"));
        colStaffID.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
    }
    
    public static void getReportTable()
    {
        try{
        Connection connection;
            connection = ConnectDB.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("Select * from Report");
        
        while(rs.next())
        {
            ReportList.add(
                    new Report1(rs.getString("ReportID"), rs.getString("type"), rs.getString("reportingDate"),
                    rs.getString("StaffID")));
        }
        
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
}
