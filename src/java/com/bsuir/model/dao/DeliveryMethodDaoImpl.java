/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.dao;

import com.bsuir.model.entity.DeliveryMethod;
import com.bsuir.model.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Katya Omelyashchik
 */
public class DeliveryMethodDaoImpl extends DaoImpl {

    public DeliveryMethodDaoImpl() {
        super(DeliveryMethod.class);
    }

    @Override
    public DeliveryMethod readByNameDelivery(String delivary) {
        try{
        DeliveryMethod deliveryMethod;
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        deliveryMethod = (DeliveryMethod) session.getNamedQuery("SELECT_BY_DELIVERY")
                .setString("nameDm", delivary)                
                .list()
                .get(0);
        return deliveryMethod;
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in readByNameDelivery(String delivary)");
        }
    }

}
