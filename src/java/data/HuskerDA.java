/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Category;
import business.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author qa521357
 */
public class HuskerDA {
//     public static ArrayList<Product> getAllProducts() {
//        ArrayList<Product> all = new ArrayList<Product>();
//        all.add(new Product("Aaron", "A", "Aaronson", "65",
//                LocalDate.of(1980, Month.JANUARY, 1), LocalDate.of(2013, Month.JANUARY, 2)));
//
//        all.add(new Product("Erin", "E", "Erinson", "66",
//                LocalDate.of(1980, Month.JANUARY, 1), LocalDate.of(2012, Month.JANUARY, 1)));
//
//        all.add(new Product("Beatrix", "", "Kiddo", "1313",
//                LocalDate.of(1976, Month.FEBRUARY, 28), LocalDate.of(2003, Month.OCTOBER, 10)));
//
//        all.add(new Product("Paul", "Muad'Dib", "Atreides", "2000",
//                LocalDate.of(1965, Month.APRIL, 4), LocalDate.of(1984, Month.MAY, 5)));
//
//        all.add(new Product("Marty", "", "McFly", "1985",
//                LocalDate.of(1968, Month.JUNE, 12), LocalDate.of(1885, Month.JANUARY, 1)));
//
//        all.add(new Product("Roy", "", "Batty", "734",
//                LocalDate.of(2016, Month.JANUARY, 8), LocalDate.of(2016, Month.JANUARY, 9)));
//
//        all.add(new Product("Molly", "", "Millions", "1337",
//                LocalDate.of(1984, Month.JULY, 1), LocalDate.of(2000, Month.APRIL, 30)));
//
//        return all;
//    }
    
    

//    public static boolean addAllEmployees() {
//        ArrayList<Product> all = new ArrayList<Product>();
//       
//        for (Product emp : all) {
//             
//             ConnectionPool pool = ConnectionPool.getInstance();
//             Connection connection = pool.getConnection();
//             PreparedStatement ps = null;
//            String query
//                    = "INSERT INTO employees (firstName, middleName, lastName, employeeID, birthDate, hireDate) "
//                    + "VALUES (?, ?, ?, ?, ?, ?)";
//            try {
//                //https://stackoverflow.com/questions/29168494/how-to-convert-localdate-to-sql-date-java
//                Date dBirthDate = Date.valueOf(emp.getBirthDate());
//                Date dHireDate = Date.valueOf(emp.getHireDate());
//                
//                ps = connection.prepareStatement(query);
//                ps.setString(1, emp.getFirstName());
//                ps.setString(2, emp.getMiddleName());
//                ps.setString(3, emp.getLastName());
//                ps.setString(4, emp.getEmployeeID());
//                ps.setString(5, dBirthDate.toString());
//                ps.setString(6, dHireDate.toString());
//                ps.executeUpdate();
//                 // return ps.executeUpdate();
//            } catch (SQLException e) {
//                System.out.println(e);
//                //return 0;
//            } finally {
//                DBUtil.closePreparedStatement(ps);
//                 pool.freeConnection(connection);
//            }
//        }
//
//        return true;
//    }
//   public static ArrayList<Product> beforeDate(String sDate) {
//        ArrayList<Product> oProducts = new ArrayList<Product>();
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM employees "
//                + "WHERE hireDate < ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, sDate);
//            rs = ps.executeQuery();
//            Product person = null;
//            while (rs.next()) {
//                person = new Product();
//                person.setFirstName(rs.getString("firstName"));
//                person.setMiddleName(rs.getString("middleName"));
//                person.setLastName(rs.getString("lastName"));
//                person.setEmployeeID("" + rs.getInt("employeeID"));
//                person.setBirthDate(rs.getDate("birthDate").toLocalDate());
//                person.setHireDate(rs.getDate("hireDate").toLocalDate());
//                oProducts.add(person);
//            }
//            return oProducts;
//            
//        } catch (SQLException e) {
//            System.out.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
   
    
//    public static ArrayList<Product> afterDate(String sDate) {
//        ArrayList<Product> oProducts = new ArrayList<Product>();
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM employees "
//                + "WHERE hireDate > ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, sDate);
//            rs = ps.executeQuery();
//            Product person = null;
//            while (rs.next()) {
//                person = new Product();
//                person.setFirstName(rs.getString("firstName"));
//                person.setMiddleName(rs.getString("middleName"));
//                person.setLastName(rs.getString("lastName"));
//                person.setEmployeeID("" + rs.getInt("employeeID"));
//                person.setBirthDate(rs.getDate("birthDate").toLocalDate());
//                person.setHireDate(rs.getDate("hireDate").toLocalDate());
//                oProducts.add(person);
//            }
//            return oProducts;
//            
//        } catch (SQLException e) {
//            System.out.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
    
//    public static Product getUser(String id) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Product person = null;
//        String query = "SELECT * FROM employees "
//                + "WHERE employeeID = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, id);
//            rs = ps.executeQuery();
//           person = new Product();
//           while (rs.next()) {
//                person.setFirstName(rs.getString("firstName"));
//                person.setMiddleName(rs.getString("middleName"));
//                person.setLastName(rs.getString("lastName"));
//                person.setEmployeeID("" + rs.getInt("employeeID"));
//                person.setBirthDate(rs.getDate("birthDate").toLocalDate());
//                person.setHireDate(rs.getDate("hireDate").toLocalDate());
//           }
//            return person;
//        } catch (SQLException e) {
//            System.out.println(e);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
    
//    public static int AddEmployee(Product p) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query
////                = "INSERT INTO employees (Email, FirstName, LastName) "
////                + "VALUES (?, ?, ?)";
//                 = "INSERT INTO employees (firstName, middleName, lastName, employeeID, birthDate, hireDate) "
//                    + "VALUES (?, ?, ?, ?, ?, ?)";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, p.getFirstName());
//            ps.setString(2, p.getMiddleName());
//            ps.setString(3, p.getLastName());
//            ps.setString(4, p.getEmployeeID());
//            ps.setString(5, p.getBirthDate().toString());
//            ps.setString(6, p.getHireDate().toString());
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return 0;
//        } finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }
    
//     public static int update(Product p) {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query = "UPDATE employees SET "
//                + "firstName = ?, "
//                + "middleName = ?, "
//                + "lastName = ?, "
//                + "employeeID = ?, "
//                + "birthDate = ?, "
//                + "hireDate = ? "
//                + "WHERE employeeID = ?";
//        try {
//            Date dBirthDate = Date.valueOf(p.getBirthDate());
//            Date dHireDate = Date.valueOf(p.getHireDate());
//            ps = connection.prepareStatement(query);
//            ps.setString(1, p.getFirstName());
//            ps.setString(2, p.getMiddleName());
//            ps.setString(3, p.getLastName());
//            ps.setString(4, p.getEmployeeID());
//            ps.setString(5, dBirthDate.toString());
//            ps.setString(6, dHireDate.toString());
//            ps.setString(7, p.getEmployeeID());
//
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//            return 0;
//        } finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> oProducts = new ArrayList<Product>();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM product";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Product product = null;
            while (rs.next()) {
                product = new Product();
                product.setProductID(Integer.parseInt(rs.getString("ProductID")));
                product.setCatagoryID(Integer.parseInt(rs.getString("CategoryID")));
                product.setPrice(Double.parseDouble(rs.getString("price")));
                product.setProductName(rs.getString("productName"));
                //product.setProductDesc("");
                product.setImagePath(rs.getString("ImagePath"));
                oProducts.add(product);
            }
            return oProducts;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
        public static Category getCategoryObject(Category oCategory) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM category "
                + "WHERE categoryName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, oCategory.getCatagoryName());
            rs = ps.executeQuery();
           while (rs.next()) {
               oCategory.setCatagoryID(Integer.parseInt(rs.getString("CategoryID")));
           }
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            return oCategory;
        }
        
    }
        
        
        
            public static ArrayList<Product> getCategoryProducts(String sCategoryID) {
        ArrayList<Product> oProducts = new ArrayList<Product>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM product "
                + "WHERE CategoryID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, sCategoryID);
            rs = ps.executeQuery();
            Product oProduct = null;
            while (rs.next()) {
                oProduct = new Product();
                oProduct.setProductID(Integer.parseInt(rs.getString("ProductID")));
                oProduct.setCatagoryID(Integer.parseInt(rs.getString("CategoryID")));
                oProduct.setPrice(Double.parseDouble(rs.getString("price")));
                oProduct.setProductName(rs.getString("productName"));
                oProduct.setProductDesc("");
                oProduct.setImagePath(rs.getString("ImagePath"));
                oProducts.add(oProduct);
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            return oProducts;
        }
    }
            
            
            public static Product getSpecificProduct(String sProductID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product oProduct = null;    
        String query = "SELECT * FROM product "
                + "WHERE ProductID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, sProductID);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                oProduct = new Product();
                oProduct.setProductID(Integer.parseInt(rs.getString("ProductID")));
                oProduct.setCatagoryID(Integer.parseInt(rs.getString("CategoryID")));
                oProduct.setPrice(Double.parseDouble(rs.getString("price")));
                oProduct.setProductName(rs.getString("productName"));
                oProduct.setProductDesc(rs.getString("productDesc"));
                oProduct.setImagePath(rs.getString("ImagePath"));
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            return oProduct;
        }
    }
}
