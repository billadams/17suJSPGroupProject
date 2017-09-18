package controller;

import business.*;
import data.HuskerDA;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartController extends HttpServlet {

        /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext sc = getServletContext();
        String url = "/index.jsp";
        HttpSession oSession = request.getSession();
        String sErrorMessage = "";
        boolean bIsValid = true;
        int cartTotalItems = 0;
        
        Cart oCart = (Cart)oSession.getAttribute("oCart");
        if (oCart == null) {
            oCart = new Cart();                
        }
        
        String sAction = request.getParameter("action");
        
        if (sAction.equals("cart")) {
            String sProductID = request.getParameter("productID");
            String sQuantity = request.getParameter("quantity");
            int quantity = 0;
            
            try {
                quantity = Integer.parseInt(sQuantity);
                //TODO come back and mess with validation logic
            } 
            catch (Exception e) {
                bIsValid = false;
            }
            
            Product oProduct = HuskerDA.getSpecificProduct(sProductID);
            LineItem lineItem = new LineItem();
            lineItem.setProduct(oProduct);
            lineItem.setQuantity(quantity);
            
            if (quantity == 0){
                //remove item
                oCart.removeItem(lineItem);
            }
            else if (quantity >0){
                //add item logic
                oCart.addItem(lineItem);
            }
                
            oSession.setAttribute("oCart", oCart);

            url = "/products.jsp";  
        }
        else if (sAction.equals("update")) {
            String sProductID = request.getParameter("productID");
            String sQuantity = request.getParameter("quantity");
            int quantity = 0;
            
            try {
                quantity = Integer.parseInt(sQuantity);
                //TODO come back and mess with validation logic
            } 
            catch (Exception e) {
                bIsValid = false;
            }
            
            Product oProduct = HuskerDA.getSpecificProduct(sProductID);
            LineItem lineItem = new LineItem();
            lineItem.setProduct(oProduct);
            lineItem.setQuantity(quantity);
            
            if (quantity == 0){
                //remove item
                oCart.removeItem(lineItem);
            }
            else if (quantity >0){
                //add item logic
                oCart.updateItem(lineItem);
            }

             oSession.setAttribute("oCart", oCart);

              url = "/products.jsp";   
        }            
        else if (sAction.equals("checkout")){
            oCart = (Cart) oSession.getAttribute("oCart");

            request.setAttribute("oCart", oCart);
            url = "/checkout.jsp";
        }
        else if (sAction.equals("completeOrder")) {
            
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
            Customer oCustomerTest = new Customer(0,"s","s","s","s","s","s","s","s"); 

            int nCatcher = HuskerDA.AddCustomer(oCustomerTest);
            String breakpoint = "";
            
            url = "/thanks.jsp";
            
        }
        
        //README
        //Whenever add product to cart is selected it will come here
        //we will pull productID

        // Get the count of all items in the shopping cart.
        cartTotalItems = oCart.getCount();
        oSession.setAttribute("cartTotalItems", cartTotalItems);
        
        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
