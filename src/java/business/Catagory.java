/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author nc520675
 */
public class Catagory implements Serializable {
    private int catagoryID;
    private String catagoryName;
    
    public Catagory(){
        
    }
    
    public Catagory(int catagoryID, String catagoryName){
        this.catagoryID = catagoryID;
        this.catagoryName = catagoryName;
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
     * @return the catagoryName
     */
    public String getCatagoryName() {
        return catagoryName;
    }

    /**
     * @param catagoryName the catagoryName to set
     */
    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }
    
}
