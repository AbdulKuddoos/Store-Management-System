/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import sqlconnectivity.ConnectDB;

/**
 * FXML Controller class
 *
 * @author Abdul Quddoos
 */
public class LogInController implements Initializable {

  
    @FXML
    private Button sign_In_btn;
    @FXML
    private Button sign_Up_btn;
    @FXML
    private SplitPane splitPane;
    @FXML
    private Button logIn_Btn;
    @FXML
    private TextField username_LogIn;
    @FXML
    private PasswordField password_LogIn;
    @FXML
    private TextField username_SignUp;
    @FXML
    private TextField password_SignUp;
    @FXML
    private TextField email_SignUp;
    @FXML
    private TextField address_SignUp;
    @FXML
    private TextField fullName_SignUp;
    @FXML
    private TextField staffID_SignUp;
    @FXML
    private Button submit_SignUp;
    @FXML
    private ComboBox  positionChoiceBox;
    
    private final ObservableList<String> positionValues = FXCollections.observableArrayList("Admin", "Receptionist");

    
        BooleanProperty collapsed = new SimpleBooleanProperty();
        
    ConnectDB connection = null;
    @FXML
    private TextField phoneNo_SignUp;
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connection = new ConnectDB();
        // TODO
        splitPane.setDividerPositions(0.4);
        collapsed.bind(splitPane.getDividers().get(0).positionProperty().isEqualTo(0, 0.01));
        positionChoiceBox.setValue("Admin");
        positionChoiceBox.setItems(positionValues);
    }    

    @FXML
    private void actionOnSignInBtn(ActionEvent event) {
        double target = collapsed.get() ? 1.0 : 1.0 ;
        KeyValue keyValue = new KeyValue(splitPane.getDividers().get(0).positionProperty(), target);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(800), keyValue));
        timeline.play();
    }

    @FXML
    private void actionOnSignUnBtn(ActionEvent event) {
        double target = collapsed.get() ? 0.0 : 0.0 ;
        KeyValue keyValue = new KeyValue(splitPane.getDividers().get(0).positionProperty(), target);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(800), keyValue));
        timeline.play();
    }

    public String getPosition()
    {
        return positionChoiceBox.getValue().toString();
    }
    
    @FXML
    private void actionOnLogInBtn(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

            if(!(username_LogIn.getText().trim().isEmpty() || password_LogIn.getText().trim().isEmpty()))
                if(connection.checkUser(username_LogIn.getText()))
                {
                    if(connection.getUser(username_LogIn.getText(),password_LogIn.getText()))
                    {
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setTitle("Welcome back");
                        alert.setHeaderText("Logged In!");
                        alert.setContentText("Correct Password and Username!");
                        try
                        {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));  
                            stage.setTitle("SMS");
                            stage.show();
                        }
                        catch(IOException e)
                        {
                            System.out.println(e);
                        }
                    }
                    else
                    {
                        alert.setTitle("Who are you?");
                        alert.setHeaderText("Log in failed");
                        alert.setContentText("Incorrect Password");
                    }
                }
                else
                {
                    alert.setTitle("Who are you?");
                    alert.setHeaderText("Log in failed");
                    alert.setContentText("Incorrect Username or Password");
                }
            else
            {
                alert.setTitle("Error");
                alert.setHeaderText("Registeration error");
                alert.setContentText("If you have not registered yet\nPlease Sign up First");
            }
                alert.showAndWait();
                
            
    }

    @FXML
    private void actionOnSubmitBtn(ActionEvent event) {
        if(!(username_SignUp.getText().trim().isEmpty() 
                || password_SignUp.getText().trim().isEmpty() 
                || staffID_SignUp.getText().trim().isEmpty()
                || email_SignUp.getText().trim().isEmpty()))
        {
            
            if(password_SignUp.getText().length() <= 8){
                if(connection.signUp(staffID_SignUp.getText(),fullName_SignUp.getText(),username_SignUp.getText(),password_SignUp.getText(), positionChoiceBox.getValue().toString() , email_SignUp.getText(), address_SignUp.getText(), phoneNo_SignUp.getText()))
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registered");
                    alert.setHeaderText("User registered");
                    alert.setContentText("You may login now");
                    alert.showAndWait();
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("User not registered");
                    alert.setContentText("StaffID or Username already registered\n Your Password is too weak");
                    alert.showAndWait();
                }
        
            }
            else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("User not registered");
                    alert.setContentText("Password must be composed of 8 figures");
                    alert.showAndWait();
                }
        }
        else
        {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Restriction");
                    alert.setHeaderText("User not registered");
                    alert.setContentText("You have to enter StaffID, Name, Username, Password and Email");
                    alert.showAndWait();
        }
     
    }
    
      
}
