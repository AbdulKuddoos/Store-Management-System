/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class ReportsController implements Initializable {

    @FXML
    private Pane statusPane;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusAddress_lbl;
    @FXML
    private TableView<?> tableReport;
    @FXML
    private TableColumn<?, ?> colReportID;
    @FXML
    private TableColumn<?, ?> colReportType;
    @FXML
    private TableColumn<?, ?> colReportingDate;
    @FXML
    private TableColumn<?, ?> colStaffID;
    @FXML
    private Button btnAddReport;
    @FXML
    private Button btnViewDetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionOnAddReports(ActionEvent event) {
    }

    @FXML
    private void actionOnViewDetails(ActionEvent event) {
    }
    
}
