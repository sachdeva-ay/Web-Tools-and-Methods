package com.neu.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author HP
 */
public class BooksController extends AbstractController {
    
    public BooksController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        DataSource ds = (DataSource) this.getApplicationContext().getBean("myDataSource");
        
        String action = request.getParameter("action");
        ModelAndView mv = new ModelAndView();
        QueryRunner run = new QueryRunner(ds);
        HttpSession session = request.getSession();
        
         if (action.equalsIgnoreCase("controller")) {
             int count=Integer.parseInt(request.getParameter("number"));
             request.setAttribute("count", count);
             mv.setViewName("MovieList.jsp");
         }
         else if(action.equalsIgnoreCase("addBooks")){
            String isbn_array[] = request.getParameterValues("isbn");
            String title_array[] = request.getParameterValues("title");
            String author_array[] = request.getParameterValues("author");
            String price_array[] = request.getParameterValues("price");
            
            Object[] params = new Object[4];
                    params[0] = isbn_array;
                    params[1] = title_array;                   
                    params[2] = author_array;
                    params[3] = price_array;
                    
                    int inserts = run.update("insert into book(isbn,title,author,price) values (?,?,?,?)", params);
                    mv.setViewName("index");
                
         }
         return mv;
    }
    
}
