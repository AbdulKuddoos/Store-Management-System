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
public class Supplier {
    
    
    private String supplierID;
    private String name;
    private String email;
    private String phoneNo;

    public Supplier(String supplierID, String name, String email, String phoneNo) {
        this.supplierID = supplierID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
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
