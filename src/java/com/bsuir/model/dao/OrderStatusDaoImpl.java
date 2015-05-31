/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.dao;

import com.bsuir.model.entity.OrderStatus;
import com.bsuir.model.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;




/**
 *
 * @author Katya Omelyashchik
 */

public class OrderStatusDaoImpl extends DaoImpl{

    public OrderStatusDaoImpl() {
        super(OrderStatus.class);
    }
  
    @Override
    public OrderStatus readByNameStatus(String status) {
        try{
        OrderStatus orderStatus;
        Session session = HibernateUtil.getSessionFactory();        
        orderStatus = (OrderStatus) session.getNamedQuery("SELECT_BY_STATUS")
                .setString("nameStatus", status)
                .list()
                .get(0);
        return orderStatus;
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in readByNameStatus(String status)");
        }

    }
}