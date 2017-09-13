package controller;

import business.*;
import data.HuskerDA;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//import murach.data.*;
//import murach.business.*;

public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext sc = getServletContext();
        String url = "/index.jsp";
        HttpSession oSession = request.getSession();
        String sErrorMessage = "";
        boolean bIsValid = true;
        Cart oCart = (Cart)oSession.getAttribute("oCart");
       // Cart oCart = session.get
        if (oCart == null) {
                oCart = new Cart();                
            }
        

        //Product oProduct = HuskerDA.getSpecificProduct("1");
        String sAction = request.getParameter("action");
        if(sAction.equals("cart")){
            String sProductID = request.getParameter("productID");
        String sQuantity = request.getParameter("quantity");
        int quantity = 0;
        try {
                quantity = Integer.parseInt(sQuantity);
                //TODO come back and mess with validation logic
            } catch (Exception e) {
               bIsValid = false;
               
            }
        Product oProduct = HuskerDA.getSpecificProduct(sProductID);
        LineItem lineItem = new LineItem();
        lineItem.setProduct(oProduct);
            lineItem.setQuantity(quantity);
        if(quantity == 0){
        //remove item
        oCart.removeItem(lineItem);
        }
        else if(quantity >0){
            //add item logic
        
        
        oCart.addItem(lineItem);
        }

             
       
         oSession.setAttribute("oCart", oCart);
         
          url = "/products.jsp";  
        }
        else if(sAction.equals("update")){
            String sProductID = request.getParameter("productID");
        String sQuantity = request.getParameter("quantity");
        int quantity = 0;
        try {
                quantity = Integer.parseInt(sQuantity);
                //TODO come back and mess with validation logic
            } catch (Exception e) {
               bIsValid = false;
               
            }
        Product oProduct = HuskerDA.getSpecificProduct(sProductID);
        LineItem lineItem = new LineItem();
        lineItem.setProduct(oProduct);
            lineItem.setQuantity(quantity);
        if(quantity == 0){
        //remove item
        oCart.removeItem(lineItem);
        }
        else if(quantity >0){
            //add item logic
        
        
        oCart.updateItem(lineItem);
        }

             
       
         oSession.setAttribute("oCart", oCart);
         
          url = "/products.jsp";   
        }
        
            
        if(sAction.equals("checkout")){
           String sFirstName = request.getParameter("firstName"); 
           String sLastName = request.getParameter("lastName"); 
           String sStreet = request.getParameter("street"); 
           String sCity = request.getParameter("city"); 
           String sState = request.getParameter("state"); 
           String sZip = request.getParameter("zip"); 
           String sEmail = request.getParameter("email"); 
           String sPhoneNumber = request.getParameter("phone"); 
           //int customerID, String firstName, String lastName, String street, String city, String state, String zip, String phone, String email
           Customer oCustomer = new Customer(0,sFirstName,sLastName,sStreet,sCity,sState,sZip,sPhoneNumber,sEmail);
            
           url = "/checkout.jsp";
        }
        
        
        //README
        //Whenever add product to cart is selected it will come here
        //we will pull productID
        
        
        
        
        
//        // get current action
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "cart";  // default action
//        }
//
//        // perform action and set URL to appropriate page
//        String url = "/index.jsp";
//        if (action.equals("shop")) {
//            url = "/index.jsp";    // the "index" page
//        } 
//        else if (action.equals("cart")) {
//            String productID = request.getParameter("productID");
//            String quantityString = request.getParameter("quantity");
//
//            HttpSession session = request.getSession();
//            Cart cart = (Cart) session.getAttribute("cart");
//            if (cart == null) {
//                cart = new Cart();
//            }
//
//            //if the user enters a negative or invalid quantity,
//            //the quantity is automatically reset to 1.
//            int quantity;
//            try {
//                quantity = Integer.parseInt(quantityString);
//                if (quantity < 0) {
//                    quantity = 1;
//                }
//            } catch (NumberFormatException nfe) {
//                quantity = 1;
//            }
//
//           
//           
//
//            LineItem lineItem = new LineItem();
//            lineItem.setProduct(product);
//            lineItem.setQuantity(quantity);
//            if (quantity > 0) {
//                cart.addItem(lineItem);
//            } else if (quantity == 0) {
//                cart.removeItem(lineItem);
//            }
//
//            session.setAttribute("cart", cart);
//            url = "/cart.jsp";
//        }
//        else if (action.equals("checkout")) {
//            url = "/checkout.jsp";
//        }

        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
}
