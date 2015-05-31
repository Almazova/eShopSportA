/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.dao;

import java.util.List;
import com.bsuir.model.entity.PaymentMethod;
import com.bsuir.model.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Katya Omelyashchik
 */
public class PaymentMethodDaoImpl extends DaoImpl {

    public PaymentMethodDaoImpl() {
        super(PaymentMethod.class);
    }

    @Override
    public PaymentMethod readByNamePayment(String payment) {
        try{
        PaymentMethod paymentMethod;
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        paymentMethod = (PaymentMethod) session.getNamedQuery("SELECT_BY_PAYMENT")
                .setString("namePm", payment)
                .list()
                .get(0);
        return paymentMethod;
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in readByNamePayment(String payment)");
        }

    }
}
