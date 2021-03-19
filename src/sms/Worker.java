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
public class Worker {
    
    private String workerID;
    private String name;
    private String sex;
    private String phoneNo;
    private String address;
    private BigDecimal salary;

    public Worker(String workerID, String name, String sex, String phoneNo, String address, BigDecimal salary) {
        this.workerID = workerID;
        this.name = name;
        this.sex = sex;
        this.phoneNo = phoneNo;
        this.address = address;
        this.salary = salary;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
}
