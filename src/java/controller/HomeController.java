/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Category;
import business.Product;
import data.ConnectionPool;
import data.HuskerDA;
import static data.HuskerDA.getAllProducts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author qa521357
 */
public class HomeController extends HttpServlet {

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
        String sCategory = "";
        String url = "/index.jsp";
        HttpSession oSession = request.getSession();
        Category oCategory = new Category();
        //ArrayList<Product> oProducts = getAllfromDB();
        String sAction = request.getParameter("action");
        if (sAction.equals("filter")) {
            sCategory = request.getParameter("category");
            ArrayList<Product> oProducts = new ArrayList<Product>();
            if(sCategory.equals("all")){
              oProducts = HuskerDA.getAllProducts();
            }
            else{
                oCategory.setCatagoryName(sCategory);
            
            oCategory = HuskerDA.getCategoryObject(oCategory);
            oProducts = HuskerDA.getCategoryProducts("" + oCategory.getCatagoryID());
            }

            if (oProducts != null) {
                request.setAttribute("oProducts", oProducts);
            }
            url = "/products.jsp";
        }else if(sAction.equals("add")){
            
             Product oProduct = HuskerDA.getSpecificProduct("1");
            String quantity = request.getParameter("quantity");
            
            oSession.setAttribute("oProduct", oProduct);
            oSession.setAttribute("quantity", quantity);
            
            url = "/cart.jsp";
        }

        boolean bIsValid = true;
        Product oProduct = new Product();

        String breakpoint = "";

//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        String breakpoint = "";
        request.setAttribute("msg", sCategory);
        
        getServletContext()
                .getRequestDispatcher(url)
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
