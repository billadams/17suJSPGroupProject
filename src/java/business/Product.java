/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author nc520675
 */
public class Product implements Serializable {
    private int productID;
    private int catagoryID;
    private double price;
    private String productName;
    private String productDesc;
    private String imagePath;
    
    public Product(){
        
    }
    public Product(int productID, int catagoryID, double price, String productName, String productDesc, String imagePath){
        this.productID =productID;
        this.catagoryID = catagoryID;
        this.price = price;
        this.productName = productName;
        this.productDesc = productDesc;
        this.imagePath = imagePath;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the catagoryID
     */
    public int getCatagoryID() {
        return catagoryID;
    }

    /**
     * @param catagoryID the catagoryID to set
     */
    public void setCatagoryID(int catagoryID) {
        this.catagoryID = catagoryID;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productDesc
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * @param productDesc the productDesc to set
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
}
