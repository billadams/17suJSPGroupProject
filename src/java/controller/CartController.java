package controller;

import business.*;
import data.HuskerDA;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        List<String> errorMessages = new ArrayList<String>();
        String sErrorMessage = "";
        boolean bIsValid = true;
        int cartTotalItems = 0;

        Cart oCart = (Cart) oSession.getAttribute("oCart");
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
            } catch (Exception e) {
                bIsValid = false;
            }

            Product oProduct = HuskerDA.getSpecificProduct(sProductID);
            LineItem lineItem = new LineItem();
            lineItem.setProduct(oProduct);
            lineItem.setQuantity(quantity);

            if (quantity == 0) {
                //remove item
                oCart.removeItem(lineItem);
                url = "/cart.jsp";
            } else if (quantity > 0) {
                //add item logic
                oCart.addItem(lineItem);
                url = "/products.jsp";
            }

            oSession.setAttribute("oCart", oCart);

        } else if (sAction.equals("update")) {
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

            if (quantity == 0) {
                //remove item
                oCart.removeItem(lineItem);
            } else if (quantity > 0) {
                //add item logic
                oCart.updateItem(lineItem);

            }

            oSession.setAttribute("oCart", oCart);

            url = "/cart.jsp";
        } else if (sAction.equals("checkout")) {
            oCart = (Cart) oSession.getAttribute("oCart");

            State states;

            request.setAttribute("oCart", oCart);
            url = "/checkout.jsp";
        } else if (sAction.equals("completeOrder")) {

            String validationMessage = "";

            String sFirstName = request.getParameter("firstName");
            String sLastName = request.getParameter("lastName");
            String sStreet = request.getParameter("street");
            String sCity = request.getParameter("city");
            String sState = request.getParameter("state");
            String sZip = request.getParameter("zipcode");
            String sPhoneNumber = request.getParameter("phone");
            String sEmail = request.getParameter("email");

            // Validate the form input.
            validationMessage = FormValidation.validateStringInput(sFirstName, "First name");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            String lastName = request.getParameter("lastName");
            validationMessage = FormValidation.validateStringInput(sLastName, "Last name");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            validationMessage = FormValidation.validateStringInput(sStreet, "Street");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            validationMessage = FormValidation.validateStringInput(sCity, "City");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            validationMessage = FormValidation.validateStringInput(sState, "State");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            validationMessage = FormValidation.validateStringInput(sZip, "Zipcode");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            validationMessage = FormValidation.validateStringInput(sPhoneNumber, "Phone");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            validationMessage = FormValidation.validateStringInput(sEmail, "Email");
            if (!validationMessage.equals("")) {

                errorMessages.add(validationMessage);

            }

            //int customerID, String firstName, String lastName, String street, String city, String state, String zip, String phone, String email
            Customer oCustomer = new Customer(0, sFirstName, sLastName, sStreet, sCity, sState, sZip, sPhoneNumber, sEmail);
            // Customer oCustomerTest = new Customer(0, "s","s","s","s","s","s","s","s"); 

            // If errorMessages comes back empty (i.e. everything validated), 
            // create the customer and add it to the session.
            if (errorMessages.isEmpty()) {

                int nCustomerID = HuskerDA.AddCustomer(oCustomer);
                oCustomer.setCustomerID(nCustomerID);
                Order oOrder = new Order(0, LocalDate.now(), nCustomerID);
                oOrder.setOrderID(HuskerDA.CreateOrder(oOrder));
                //Create order
                List<LineItem> totalOrder = oCart.getItems();
                for (LineItem oItem : totalOrder) {
                    oItem.getProduct().getProductName();
                    oItem.getQuantity();
                    oItem.getTotal();
                    oOrder.getOrderID();
                    HuskerDA.TotalOrder(oItem.getProduct().getProductName(), oItem.getQuantity(), oItem.getTotal(), oOrder.getOrderID());
                }
                request.setAttribute("oCustomer", oCustomer);
                request.setAttribute("oOrder", oOrder);
                request.setAttribute("oCart", oCart);
//                oSession.invalidate();
                url = "/thanks.jsp";

            } else {

                // Set attributes the user completed and return them 
                // to the form during the validation process.
                request.setAttribute("oCustomer", oCustomer);
                request.setAttribute("errorMessages", errorMessages);
                url = "/checkout.jsp";

            }

        }

        //README
        //Whenever add product to cart is selected it will come here
        //we will pull productID
        // Get the count of all items in the shopping cart.
        oSession.setAttribute("oCart", oCart);
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
