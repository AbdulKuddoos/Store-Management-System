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


public class ProductsController implements Initializable {

    @FXML
    private Button btnAddStock;
    @FXML
    private Pane statusPane;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusAddress_lbl;
    @FXML
    private Button btnViewDetails;
    @FXML
    private TableColumn<Product, String> colProductID;
    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, String> colCategory;
    @FXML
    private TableColumn<Product, String> colPrice;
    @FXML
    private TableColumn<Product, String> colSize;
    @FXML
    private TableColumn<Product, String> colManufacturer;
    @FXML
    private TableColumn<Product, String> colStockID;
    @FXML
    private TableColumn<Product, String> colQty;

    static ObservableList<Product> ProductList = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Product> ProductTable;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void actionOnAddStock(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
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
    private void actionOnViewDetails(ActionEvent event) {
        
        colProductID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colManufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colStockID.setCellValueFactory(new PropertyValueFactory<>("StockID"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        
        
        getProductTable();
        ProductTable.setItems(ProductList);
    }
    
    
    
    public static void getProductTable()
    {
        try{
        Connection connection;
            connection = ConnectDB.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("Select * from [Stock Details]");
        
        while(rs.next())
        {
            ProductList.add(
                    new Product(rs.getString("ProductID"), rs.getString("Name"), rs.getString("category"),
                    new BigDecimal(rs.getString("price")), rs.getString("size"), rs.getString("Manufacturer"),
                    rs.getString("StockID"), rs.getString("Qty")));
        }
        
        }catch(NumberFormatException | SQLException e)
        {
            System.out.println(e + "Exception is here");
        }
    }

}
