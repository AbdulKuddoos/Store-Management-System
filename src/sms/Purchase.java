/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.math.BigDecimal;

/**
 *
 * @author Abdul Quddoos
 */
public class Purchase {
    
    private String purchaseID;
    private BigDecimal purchasingCost;
    private String date;
    private String staffID;
    private String supplierID;
    private String name;
    private String email;
    private String phoneNo;

    public Purchase(String purchaseID, BigDecimal purchasingCost, String date, String staffID, String supplierID, String name, String email, String phoneNo) {
        this.purchaseID = purchaseID;
        this.purchasingCost = purchasingCost;
        this.date = date;
        this.staffID = staffID;
        this.supplierID = supplierID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public BigDecimal getPurchasingCost() {
        return purchasingCost;
    }

    public void setPurchasingCost(BigDecimal purchasingCost) {
        this.purchasingCost = purchasingCost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    
}
