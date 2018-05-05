/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.Bean.SalesOrder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.sql.*;
import java.util.ArrayList;
import org.relique.jdbc.csv.CsvDriver;

/**
 *
 * @author HP
 */
public class ReadController extends AbstractController {
    
    public ReadController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
      //  String filename=request.getParameter("filename");
        ModelAndView mv = new ModelAndView();

       HttpSession session = request.getSession();

     if (action.equalsIgnoreCase("load")) {
            String filename=request.getParameter("filename");
            String path="D:\\";
            // Load the driver.
        Class.forName("org.relique.jdbc.csv.CsvDriver");

    // Create a connection. The first command line parameter is
    // the directory containing the .csv files.
    // A single connection is thread-safe for use by several threads.
        Connection conn = DriverManager.getConnection("jdbc:relique:csv:"+path);

    // Create a Statement object to execute the query with.
    // A Statement is not thread-safe.
    Statement stmt = conn.createStatement();

    // Select the ID and NAME columns from sample.csv
    String query = "SELECT * FROM " + filename;
    ResultSet rs = stmt.executeQuery(query);

    ArrayList<SalesOrder> soList=new ArrayList<SalesOrder>();
         while(rs.next()){
            //Retrieve by column name
            SalesOrder so=new SalesOrder();
            
            so.setSalesOrderID(rs.getString("SalesOrderID"));
            so.setRevisionNumber(rs.getString("RevisionNumber"));
            so.setOrderDate(rs.getString("OrderDate"));
            so.setDueDate(rs.getString("DueDate"));
            so.setShipDate(rs.getString("ShipDate"));
            so.setStatus(rs.getString("Status"));
            so.setOnlineOrderFlag(rs.getString("OnlineOrderFlag"));
            so.setSalesOrderNumber(rs.getString("SalesOrderNumber"));
            so.setPurchaseOrderNumber(rs.getString("PurchaseOrderNumber"));
            so.setAccountNumber(rs.getString("AccountNumber"));
            so.setCustomerID(rs.getString("CustomerID"));
            so.setSalesPersonID(rs.getString("SalesPersonID"));
            so.setTerritoryID(rs.getString("TerritoryID"));
            so.setBillToAddressID(rs.getString("BillToAddressID"));
            so.setShipToAddressID(rs.getString("ShipToAddressID"));
            so.setShipMethodID(rs.getString("ShipMethodID"));
            so.setCreditCardID(rs.getString("CreditCardID"));
            so.setCreditCardApprovalCode(rs.getString("CreditCardApprovalCode"));
            so.setCurrencyRateID(rs.getString("CurrencyRateID"));
            so.setSubTotal(rs.getString("SubTotal"));
            so.setTaxAmt(rs.getString("TaxAmt"));
            so.setFreight(rs.getString("Freight"));
            so.setTotalDue(rs.getString("TotalDue"));
            so.setComment(rs.getString("Comment"));
            so.setModifiedDate(rs.getString("ModifiedDate"));
            soList.add(so);
          						

         }
          request.setAttribute("soList", soList);
            mv.setViewName("index");
        } else if(action.equalsIgnoreCase("insert")){
        //    ArrayList<SalesOrder>=(ArrayList<SalesOrder>)request.getAttribute("bean");
       
            String SalesOrderID_array[] = (String[])request.getParameterValues("salesOrderID");
            String RevisionNumber_array[] = (String[])request.getParameterValues("revisionNumber");
            String OrderDate_array[] = (String[])request.getParameterValues("orderDate");
            String DueDate_array[] = (String[])request.getParameterValues("dueDate");
            String ShipDate_array[] = (String[])request.getParameterValues("shipDate");
            String Status_array[] = (String[])request.getParameterValues("status");
            String OnlineOrderFlag_array[] = (String[])request.getParameterValues("onlineOrderFlag");
            String SalesOrderNumber_array[] = (String[])request.getParameterValues("salesOrderNumber");
            String PurchaseOrderNumber_array[] = (String[])request.getParameterValues("purchaseOrderNumber");
            String AccountNumber_array[] = (String[])request.getParameterValues("accountNumber");
            String CustomerID_array[] = (String[])request.getParameterValues("customerID");
            String SalesPersonID_array[] = (String[])request.getParameterValues("salesPersonID");
            String TerritoryID_array[] = (String[])request.getParameterValues("territoryID");
            String BillToAddressID_array[] = (String[])request.getParameterValues("billToAddressID");
            String ShipToAddressID_array[] = (String[])request.getParameterValues("shipToAddressID");
            String ShipMethodID_array[] = (String[])request.getParameterValues("shipMethodID");
            String CreditCardID_array[] = (String[])request.getParameterValues("creditCardID");
            String CreditCardApprovalCode_array[] = (String[])request.getParameterValues("creditCardApprovalCode");
            String CurrencyRateID_array[] = (String[])request.getParameterValues("currencyRateID");
            String SubTotal_array[] = (String[])request.getParameterValues("subTotal");
            String TaxAmt_array[] = (String[])request.getParameterValues("taxAmt");
            String Freight_array[] = (String[])request.getParameterValues("freight");
            String TotalDue_array[] = (String[])request.getParameterValues("totalDue");
            String Comment_array[] = (String[])request.getParameterValues("comment");
            String ModifiedDate_array[] = (String[])request.getParameterValues("modifiedDate");

          //  int hidden = Integer.parseInt(request.getParameter("hidden"));
            PreparedStatement pstmt=null;
            Connection conn=null;
            try{
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SalesOrderdb", "root", "admin");
       //   System.out.println("connection");
         // SalesOrderID	RevisionNumber	OrderDate	DueDate	ShipDate	Status	OnlineOrderFlag	SalesOrderNumber	PurchaseOrderNumber	AccountNumber	CustomerID	SalesPersonID	TerritoryID	BillToAddressID	ShipToAddressID	ShipMethodID	CreditCardID	CreditCardApprovalCode	CurrencyRateID	SubTotal	TaxAmt	Freight	TotalDue	Comment	ModifiedDate

         String query = "INSERT INTO salesorder (SalesOrderID,RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,SalesOrderNumber,PurchaseOrderNumber,AccountNumber,CustomerID,SalesPersonID,TerritoryID,BillToAddressID,ShipToAddressID,ShipMethodID,CreditCardID,CreditCardApprovalCode,CurrencyRateID,SubTotal,TaxAmt,\n" +
"Freight,TotalDue,Comment,ModifiedDate)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         pstmt = conn.prepareStatement(query);
         for (int i = 0; i < 4; i++) {
                pstmt.setString(1, SalesOrderID_array[i]);
                pstmt.setString(2, RevisionNumber_array[i]);
                pstmt.setString(3, OrderDate_array[i]);
                pstmt.setString(4, DueDate_array[i]);
                pstmt.setString(5, ShipDate_array[i]);
                pstmt.setString(6, Status_array[i]);
                pstmt.setString(7, OnlineOrderFlag_array[i]);
                pstmt.setString(8, SalesOrderNumber_array[i]);
                pstmt.setString(9, PurchaseOrderNumber_array[i]);
                pstmt.setString(10, AccountNumber_array[i]);
                pstmt.setString(11, CustomerID_array[i]);
                pstmt.setString(12, SalesPersonID_array[i]);
                pstmt.setString(13, TerritoryID_array[i]);
                pstmt.setString(14, BillToAddressID_array[i]);
                pstmt.setString(15, ShipToAddressID_array[i]);
                pstmt.setString(16, ShipMethodID_array[i]);
                pstmt.setString(17, CreditCardID_array[i]);
                pstmt.setString(18, CreditCardApprovalCode_array[i]);
                pstmt.setString(19, CurrencyRateID_array[i]);
                pstmt.setString(20, SubTotal_array[i]);
                pstmt.setString(21, TaxAmt_array[i]);
                pstmt.setString(22, Freight_array[i]);
                pstmt.setString(23, TotalDue_array[i]);
                pstmt.setString(24, Comment_array[i]);
                pstmt.setString(25, ModifiedDate_array[i]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            request.setAttribute("success", "true");
            mv.setViewName("index");

        } catch(Exception e){
         //Handle errors for Class.forName
                System.out.println(e);
         
      }finally{
         //finally block used to close resources
         try{
            if(pstmt!=null)
               pstmt.close();
         }catch(SQLException se2){
         }// nothing we can do
         try{
            if(conn!=null)
            conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         }//end finally try
      } //end try
     
    }
     return mv;
    }
}
