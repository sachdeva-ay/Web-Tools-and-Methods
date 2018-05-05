package com.hotelbooking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hotelbooking.pojo.Hotel;
import com.hotelbooking.pojo.Rate;



public class RateDao extends DAO{

	public RateDao(){
		
	}
	
	public Rate register(Rate r) throws Exception {
		try {
			begin();
			System.out.println("inside RateDAO");
			getSession().save(r);
			commit();
			return r;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating policy: " + e.getMessage());
		}
	}
	
    public List<Rate> list() throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Rate");
            List<Rate> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the Rates", e);
        }
    }
    
    public Rate getRate(String rateName) throws Exception{
    	try{
    	begin();
    	Query q = getSession().createQuery("from Rate where rate_Name= :type");
    	 q.setString("type",rateName);
    	 Rate rate= (Rate)q.uniqueResult();
    	 commit();
		return rate;
    	}
    	catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get Rate obj", e);
        }
    	
    }
	
}
