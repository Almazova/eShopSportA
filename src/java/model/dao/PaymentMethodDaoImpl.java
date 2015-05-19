/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entity.PaymentMethod;
import model.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author asus
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
