/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.util.List;
import model.entity.OrderedGoods;
import model.entity.Orders;

import model.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author asus
 */
public class OrderedGoodsDaoImpl extends DaoImpl {

    public OrderedGoodsDaoImpl() {
        super(OrderedGoods.class);
    }

    @Override
    public List<OrderedGoods> readOrderedGoodsByStatus(String nameStatus) {
        List<OrderedGoods> orderedGoods;
        Session session = HibernateUtil.getSessionFactory();
        orderedGoods = (List<OrderedGoods>) session.getNamedQuery("SELECT_BY_STATUS_NAME")
                .setString("nameStatus", nameStatus)
                .list();
        return orderedGoods;
    }

    @Override
    public void deleteOrderedGoodsByOrder(Orders order) {
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();        
        session.getNamedQuery("DELETE_BY_ORDER").setLong("idorder", order.getOrdersId()).executeUpdate(); 
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public List<OrderedGoods> readOrderedGoodsByOrder(long idOrder){
        List<OrderedGoods> orderedGoods;
        Session session = HibernateUtil.getSessionFactory();
        orderedGoods = (List<OrderedGoods>) session.getNamedQuery("SELECT_BY_ORDER")
                .setLong("idorder", idOrder)
                .list();
        return orderedGoods;
    }
}
