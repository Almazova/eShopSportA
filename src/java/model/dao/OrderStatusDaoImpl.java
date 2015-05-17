/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.OrderStatus;
import model.utils.HibernateUtil;
import org.hibernate.Session;




/**
 *
 * @author asus
 */

public class OrderStatusDaoImpl extends DaoImpl{

    public OrderStatusDaoImpl() {
        super(OrderStatus.class);
    }
  
    @Override
    public OrderStatus readByNameStatus(String status) {
        OrderStatus orderStatus = new OrderStatus();
        Session session = HibernateUtil.getSessionFactory();        
        orderStatus = (OrderStatus) session.getNamedQuery("SELECT_BY_STATUS")
                .setString("nameStatus", status)
                .list()
                .get(0);
        return orderStatus;

    }
}