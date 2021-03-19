/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class HomeController implements Initializable {

    @FXML
    private Button navBtn_Products;
    @FXML
    private Button navBtn_Sales;
    @FXML
    private Button navBtn_Purchases;
    @FXML
    private Button navBtn_Customers;
    @FXML
    private Button navBtn_Reports;
    @FXML
    private Button navBtn_Worker;
    @FXML
    private BorderPane borderPane;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleClicks(ActionEvent event)
    {
        if(event.getSource() == navBtn_Products)
        {
            System.out.println("Products Screen on");
            FxmlLoader object = new FxmlLoader();
            Pane screen = object.getPage("Products");
            borderPane.setCenter(screen);
            
        }
        else if(event.getSource() == navBtn_Sales)
        {
            FxmlLoader object = new FxmlLoader();
            Pane screen = object.getPage("Sales");
            borderPane.setCenter(screen);
        }
        else if(event.getSource() == navBtn_Purchases)
        {
            FxmlLoader object = new FxmlLoader();
            Pane screen = object.getPage("Purchases");
            borderPane.setCenter(screen);
        }
        else if(event.getSource() == navBtn_Customers)
        {
            FxmlLoader object = new FxmlLoader();
            Pane screen = object.getPage("Customer");
            borderPane.setCenter(screen);           
        }
        else if(event.getSource() == navBtn_Reports)
        {
            FxmlLoader object = new FxmlLoader();
            Pane screen = object.getPage("Reports");
            borderPane.setCenter(screen);          
        }
        else if(event.getSource() == navBtn_Worker )
        {
            FxmlLoader object = new FxmlLoader();
            Pane screen = object.getPage("Workers");
            borderPane.setCenter(screen);         
        } 
    }

}
