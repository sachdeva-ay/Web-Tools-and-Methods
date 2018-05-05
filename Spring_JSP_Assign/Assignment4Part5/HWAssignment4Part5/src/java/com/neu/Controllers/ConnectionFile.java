/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.Controllers;

import com.neu.Beans.SalesOrderBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Hp
 */
public class ConnectionFile extends AbstractController {

    public ConnectionFile() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = (HttpSession) request.getSession();

        ModelAndView mav = new ModelAndView();

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("Submit")) {
            try {
                String filename = request.getParameter("filename");
                session.setAttribute("filename", filename);
                mav.addObject("connected", true);
                mav.setViewName("index");
            } catch (Exception e) {
                mav.addObject("file", true);
                mav.setViewName("index");
                System.out.println("Exception: " + e.getMessage());

            }
//            Class.forName("org.relique.jdbc.csv.CsvDriver");
//            Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\Bhumika\\Documents\\WebTools\\WebToolsAssignment4");
//            Statement stmt = conn.createStatement();
//            ResultSet result = null;
//            String filename = request.getParameter("filename");
//            int count = 0;
//            result = stmt.executeQuery("SELECT * FROM " + filename);
//            System.out.println("Result" + result);
//            ArrayList<SalesOrderBean> salesList = new ArrayList<SalesOrderBean>();
//            while (result.next()) {
//                count++;
//                SalesOrderBean s = new SalesOrderBean();
//                s.setSalesOrderId(result.getString("SalesOrderID"));
//                s.setRevisionNumber(result.getString("RevisionNumber"));
//                s.setOrderDate(result.getString("OrderDate"));
//                s.setDueDate(result.getString("DueDate"));
//                s.setShipDate(result.getString("ShipDate"));
//                s.setStatus(result.getString("Status"));
//                s.setOnlineOrderFlag(result.getString("OnlineOrderFlag"));
//                s.setSalesOrderNumber(result.SalesOrderBean s = new SalesOrderBean();getString("SalesOrderNumber"));
//                s.setPurchaseOrderNumber(result.getString("PurchaseOrderNumber"));
//                s.setAccountNumber(result.getString("AccountNumber"));
//                s.setCustomerId(result.getString("CustomerID"));
//                s.setSalesPersonId(result.getString("SalesPersonID"));
//                s.setTerritoryId(result.getString("TerritoryID"));
//                s.setBillToAddressId(result.getString("BillToAddressID"));
//                s.setShipToAddressId(result.getString("ShipToAddressID"));
//                s.setShipMethodId(result.getString("ShipMethodID"));
//                s.setCreditCardId(result.getString("CreditCardID"));
//                s.setCreditCardApprovalCode(result.getString("CreditCardApprovalCode"));
//                s.setCurrencyRateId(result.getString("CurrencyRateID"));
//                s.setSubTotal(result.getString("SubTotal"));
//                s.setTaxAmt(result.getString("TaxAmt"));
//                s.setFreight(result.getString("Freight"));
//                s.setTotalDue(result.getString("TotalDue"));
//                s.setComment(result.getString("Comment"));
//                s.setModifiedDate(result.getString("ModifiedDate"));
//                salesList.add(s);
//
//            }
//            session.setAttribute("salesList", salesList);
//            session.setAttribute("filename", filename);
//            session.setAttribute("count", count);
//            mav.setViewName("index");
        } else if (action.equalsIgnoreCase("Add")) {
            try {
                //int hidden = (int) session.getAttribute("count");
                //System.out.println("Count" + hidden);
                String salesOrder[] = request.getParameterValues("salesOrderId");
                String revisionNumber[] = request.getParameterValues("revisionNumber");
                String orderDate[] = request.getParameterValues("orderDate");
                String dueDate[] = request.getParameterValues("dueDate");
                String shipDate[] = request.getParameterValues("shipDate");
                String status[] = request.getParameterValues("status");
                String onlineOrderFlag[] = request.getParameterValues("onlineOrderFlag");
                String salesOrderNumber[] = request.getParameterValues("salesOrderNumber");
                String purchaseOrderNumber[] = request.getParameterValues("purchaseOrderNumber");
                String accountNumber[] = request.getParameterValues("accountNumber");
                String customerId[] = request.getParameterValues("customerId");
                String salesPersonId[] = request.getParameterValues("salesPersonId");
                String territoryId[] = request.getParameterValues("territoryId");
                String billToAddressId[] = request.getParameterValues("billToAddressId");
                String shipToAddressId[] = request.getParameterValues("shiptToAddressId");
                String shipMethodId[] = request.getParameterValues("shipMethodId");
                String creditCardId[] = request.getParameterValues("creditCardId");
                String creditCardApprovalCode[] = request.getParameterValues("creditCardApprovalCode");
                String currencyRateId[] = request.getParameterValues("currencyRateId");
                String subTotal[] = request.getParameterValues("subTotal");
                String taxAmt[] = request.getParameterValues("taxAmt");
                String freight[] = request.getParameterValues("freight");
                String totalDue[] = request.getParameterValues("totalDue");
                String comment[] = request.getParameterValues("comment");
                String modifiedDate[] = request.getParameterValues("modifiedDate");
                int length=modifiedDate.length;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesorderdb", "root", "root");
                String query = "insert into salesorder(salesOrderId,revisionNumber,orderDate,dueDate,shipDate,status,onlineOrderFlag,salesOrderNumber,purchaseOrderNumber,accountNumber,customerId,salesPersonId,territoryId,billToAddressId,shipToAddressId,shipMethodId,creditCardId,creditCardApprovalCode,currencyRateId,subTotal,taxAmt,freight,totalDue,comment,modifiedDate) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                System.out.println("Query" + query);
                PreparedStatement pstmt = con.prepareStatement(query);

                for (int i = 0; i < length; i++) {
                    pstmt.setString(1, salesOrder[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(2, revisionNumber[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(3, orderDate[i].replaceAll("[^0-9/]","").trim());
                    pstmt.setString(4, dueDate[i].replaceAll("[^0-9/]","").trim());
                    pstmt.setString(5, shipDate[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(6, status[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(7, onlineOrderFlag[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(8, salesOrderNumber[i].replaceAll("[^a-zA-Z0-9]","").trim());
                    pstmt.setString(9, purchaseOrderNumber[i].replaceAll("[^a-zA-Z0-9]","").trim());
                    pstmt.setString(10, accountNumber[i].replaceAll("[^0-9-]","").trim());
                    pstmt.setString(11, customerId[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(12, salesPersonId[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(13, territoryId[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(14, billToAddressId[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(15, shipToAddressId[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(16, shipMethodId[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(17, creditCardId[i].replaceAll("[^0-9]","").trim());
                    pstmt.setString(18, creditCardApprovalCode[i].replaceAll("[^a-zA-Z0-9]","").trim());
                    pstmt.setString(19, currencyRateId[i].replaceAll("[^a-zA-Z0-9]","").trim());
                    pstmt.setString(20, subTotal[i].replaceAll("[^0-9.]","").trim());
                    pstmt.setString(21, taxAmt[i].replaceAll("[^0-9.]","").trim());
                    pstmt.setString(22, freight[i].replaceAll("[^0-9.]","").trim());
                    pstmt.setString(23, totalDue[i].replaceAll("[^0-9.]","").trim());
                    pstmt.setString(24, comment[i].replaceAll("[^a-zA-Z0-9]","").trim());
                    pstmt.setString(25, modifiedDate[i].replaceAll("[^0-9/]","").trim());
                    pstmt.addBatch();
//                out.println(isbn_array[i]);
                }
                pstmt.executeBatch();
                session.setAttribute("length", length);
                mav.addObject("connected", false);
                mav.setViewName("index");
                
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
       }
        return mav;
    }

}
