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
public class Customers {
    
    
    private String customerID;
    private String name;
    private String sex;
    private String phoneNo;
    private String address;
    private String workerID;

    public Customers(String customerID, String name, String sex, String phoneNo, String address, String workerID) {
        this.customerID = customerID;
        this.name = name;
        this.sex = sex;
        this.phoneNo = phoneNo;
        this.address = address;
        this.workerID = workerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }
    
}
