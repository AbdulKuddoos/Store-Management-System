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
public class Report1 {
    
     private String reportID;
    private String type;
    private String reportingDate;
    private String staffID;

    public Report1(String reportID, String type, String reportingDate, String staffID) {
        this.reportID = reportID;
        this.type = type;
        this.reportingDate = reportingDate;
        this.staffID = staffID;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(String reportingDate) {
        this.reportingDate = reportingDate;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }


    
}
