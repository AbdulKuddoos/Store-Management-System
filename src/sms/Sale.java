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
public class Sale {
    
    private String SerialNo;
    private String billID;
    private String customerID;
    private String staffID;
    private String productID;
    private String qty;
    private String date;
    private String name;
    private String price;

    public Sale(String SerialNo, String billID, String customerID, String staffID, String productID, String qty, String date, String productName, String unitPrice) {
        this.SerialNo = SerialNo;
        this.billID = billID;
        this.customerID = customerID;
        this.staffID = staffID;
        this.productID = productID;
        this.qty = qty;
        this.date = date;
        this.name = productName;
        this.price = unitPrice;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String SerialNo) {
        this.SerialNo = SerialNo;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String unitPrice) {
        this.price = unitPrice;
    }
    
    
}