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
public class Product {
    
    private String productID;
    private String name;
    private String category;
    private BigDecimal price;
    private String size;
    private String Manufacturer;
    private String stockID;
    private String qty;

    public Product(String productID, String name, String category, BigDecimal price, String size, String Manufacturer, String stockID, String qty) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.size = size;
        this.Manufacturer = Manufacturer;
        this.stockID = stockID;
        this.qty = qty;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

}
