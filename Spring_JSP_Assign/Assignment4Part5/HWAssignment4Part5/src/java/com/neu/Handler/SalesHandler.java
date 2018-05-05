/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.Handler;

import com.neu.Beans.SalesOrderBean;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Hp
 */
public class SalesHandler extends SimpleTagSupport{
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    StringWriter sw = new StringWriter();

   public void doTag() throws JspException, IOException
    {
         JspWriter out= getJspContext().getOut(); 
       try{
           Class.forName("org.relique.jdbc.csv.CsvDriver");
           Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\Bhumika\\Documents\\WebTools\\WebToolsAssignment4");
           Statement stmt = conn.createStatement();
           //HttpSession session = (HttpSession) request.getSession();
           ResultSet result = null;
           result = stmt.executeQuery("SELECT * FROM " + filename);
            
               out.println("<html><body><form method='post' action='add.htm'>");
               out.println("<table border='1'>");
               out.println("<th>SalesOrderID</th>\n" +
"                    <th>RevisionNumber</th>\n" +
"                    <th>OrderDate</th>\n" +
"                    <th>DueDate</th>\n" +
"                    <th>ShipDate</th>\n" +
"                    <th>Status</th>\n" +
"                    <th>OnlineOrderFlag</th>\n" +
"                    <th>SalesOrderNumber</th>\n" +
"                    <th>PurchaseOrderNumber</th>\n" +
"                    <th>AccountNumber</th>\n" +
"                     <th>CustomerID</th>\n" +
"                    <th>SalesPersonID</th>\n" +
"                    <th>TerritoryID</th>\n" +
"                    <th>BillToAddressID</th>\n" +
"                    <th>ShipToAddressID</th>\n" +
"                    <th>ShipMethodID</th>\n" +
"                    <th>CreditCardID</th>\n" +
"                    <th>CreditCardApprovalCode</th>\n" +
"                     <th>CurrencyRateID</th>\n" +
"                    <th>SubTotal</th>\n" +
"                    <th>TaxAmt</th>\n" +
"                    <th>Freight</th>\n" +
"                    <th>TotalDue</th>\n" +
"                    <th>Comment</th>\n" +
"                    <th>ModifiedDate</th>\n" +
"                </tr>                \n" +
"            </thead>");
               //column value  
               int count=0;
               ArrayList<SalesOrderBean> salesList = new ArrayList<SalesOrderBean>();
               while (result.next()) {
                   
                   out.println("<tr>");
                       count++;
                       SalesOrderBean s = new SalesOrderBean();
                       s.setSalesOrderId(result.getString("SalesOrderID"));
                       out.println("<td><input type='text' name='salesOrderId' value='"+s.getSalesOrderId()+"'</td>");
                       s.setRevisionNumber(result.getString("RevisionNumber"));
                       out.println("<td><input type='text' name='revisionNumber' value='"+s.getRevisionNumber()+"'</td>");
                       s.setOrderDate(result.getString("OrderDate"));
                       out.println("<td><input type='text' name='orderDate' value='"+s.getOrderDate()+"'</td>");
                       s.setDueDate(result.getString("DueDate"));
                       out.println("<td><input type='text' name='dueDate' value='"+s.getDueDate()+"'</td>");
                       s.setShipDate(result.getString("ShipDate"));
                       out.println("<td><input type='text' name='shipDate' value='"+s.getShipDate()+"'</td>");
                       s.setStatus(result.getString("Status"));
                       out.println("<td><input type='text' name='status' value='"+s.getStatus()+"'/></td>");
                       s.setOnlineOrderFlag(result.getString("OnlineOrderFlag"));
                       out.println("<td><input type='text' name='onlineOrderFlag' value='"+s.getOnlineOrderFlag()+"'</td>");
                       s.setSalesOrderNumber(result.getString("SalesOrderNumber"));
                       out.println("<td><input type='text' name='salesOrderNumber' value='"+s.getSalesOrderNumber()+"'</td>");
                       s.setPurchaseOrderNumber(result.getString("PurchaseOrderNumber"));
                       out.println("<td><input type='text' name='purchaseOrderNumber' value='"+s.getPurchaseOrderNumber()+"'</td>");
                       s.setAccountNumber(result.getString("AccountNumber"));
                       out.println("<td><input type='text' name='accountNumber' value='"+s.getAccountNumber()+"'</td>");
                       s.setCustomerId(result.getString("CustomerID"));
                       out.println("<td><input type='text' name='customerId' value='"+s.getCustomerId()+"'</td>");
                       s.setSalesPersonId(result.getString("SalesPersonID"));
                       out.println("<td><input type='text' name='salesPersonId' value='"+s.getSalesPersonId()+"'</td>");
                       s.setTerritoryId(result.getString("TerritoryID"));
                       out.println("<td><input type='text' name='territoryId' value='"+s.getTerritoryId()+"'</td>");
                       s.setBillToAddressId(result.getString("BillToAddressID"));
                       out.println("<td><input type='text' name='billToAddressId' value='"+s.getBillToAddressId()+"'</td>");
                       s.setShipToAddressId(result.getString("ShipToAddressID"));
                       out.println("<td><input type='text' name='shiptToAddressId' value='"+s.getShipToAddressId()+"'</td>");
                       s.setShipMethodId(result.getString("ShipMethodID"));
                       out.println("<td><input type='text' name='shipMethodId' value='"+s.getShipMethodId()+"'</td>");
                       s.setCreditCardId(result.getString("CreditCardID"));
                       out.println("<td><input type='text' name='creditCardId' value='"+s.getCreditCardId()+"'</td>");
                       s.setCreditCardApprovalCode(result.getString("CreditCardApprovalCode"));
                       out.println("<td><input type='text' name='creditCardApprovalCode' value='"+s.getCreditCardApprovalCode()+"'</td>");
                       s.setCurrencyRateId(result.getString("CurrencyRateID"));
                       out.println("<td><input type='text' name='currencyRateId' value='"+s.getCurrencyRateId()+"'</td>");
                       s.setSubTotal(result.getString("SubTotal"));
                       out.println("<td><input type='text' name='subTotal' value='"+s.getSubTotal()+"'</td>");
                       s.setTaxAmt(result.getString("TaxAmt"));
                       out.println("<td><input type='text' name='taxAmt' value='"+s.getTaxAmt()+"'</td>");
                       s.setFreight(result.getString("Freight"));
                       out.println("<td><input type='text' name='freight' value='"+s.getFreight()+"'</td>");
                       s.setTotalDue(result.getString("TotalDue"));
                       out.println("<td><input type='text' name='totalDue' value='"+s.getTotalDue()+"'</td>");
                       s.setComment(result.getString("Comment"));
                       out.println("<td><input type='text' name='comment' value='"+s.getComment()+"'</td>");
                       s.setModifiedDate(result.getString("ModifiedDate"));
                       out.println("<td><input type='text' name='modifiedDate' value='"+s.getModifiedDate()+"'</td>");
                       salesList.add(s);
                       
                   
                   out.println("</tr>");

               } 
               out.println("</table>");
               out.println("<input type='submit' name='action' value='Add'>");
               out.println("<input type='hidden' name='hidden' value='${sessionScope.count}'>");
               out.println("</form>");

           }
       
       catch(Exception e){
           
       }
      
   }
    
    
}
