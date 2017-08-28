/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author nc520675
 */
public class Order implements Serializable {
    private int orderID;
    private LocalDate orderDate;
    
    
    public Order(){
        
    }
    
    public Order(int orderID, LocalDate orderDate){
        this.orderDate = orderDate;
        this.orderID = orderID;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the orderDate
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
