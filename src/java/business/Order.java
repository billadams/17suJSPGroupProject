/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nc520675
 */
public class Order implements Serializable {

    private int orderID;
    private LocalDate orderDate;
    private int customerID;

    public Order() {

    }

    public Order(int orderID, LocalDate orderDate, int customerID) {
        this.orderDate = orderDate;
        this.orderID = orderID;
        this.customerID = customerID;
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

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getOrderDateFormatted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        String DateFormatted = dtf.format(this.orderDate);

        return DateFormatted;
    }

}
