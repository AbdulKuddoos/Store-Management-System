/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

/**
 *
 * @author Abdul Quddoos
 */
public class Stock {
    private String StockID;
    private int qty;
    private String ProductID;

    public Stock(String StockID, int qty, String ProductID) {
        this.StockID = StockID;
        this.qty = qty;
        this.ProductID = ProductID;
    }

    public String getStockID() {
        return StockID;
    }

    public void setStockID(String StockID) {
        this.StockID = StockID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }
    
    
}
