/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.entity.DeliveryMethod;
import model.entity.Goods;
import model.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author asus
 */
public class DeliveryMethodDaoImpl extends DaoImpl {

    public DeliveryMethodDaoImpl() {
        super(DeliveryMethod.class);
    }

    @Override
    public DeliveryMethod readByNameDelivery(String delivary) {
        DeliveryMethod deliveryMethod = new DeliveryMethod();
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        deliveryMethod = (DeliveryMethod) session.getNamedQuery("SELECT_BY_DELIVERY")
                .setString("nameDm", delivary)                
                .list()
                .get(0);
        return deliveryMethod;
    }

}
