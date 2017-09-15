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
public class LineItem implements Serializable {
    
    //private int id;
    private Product product;
    private int quantity;
    //private double price;
    
    public LineItem(){
        
    }
    public LineItem(Product product, int quantity){
        this.product =product;
        this.quantity= quantity;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     public double getTotal() {
        double total = this.product.getPrice() * this.quantity;
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
  
    
}
