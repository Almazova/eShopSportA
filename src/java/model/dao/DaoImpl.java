/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.entity.Orders;
import model.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author asus
 * @param <T>
 */
public class DaoImpl<T>
        implements Dao<T> {

    private final Class<T> type;

    public DaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void create(T o) {
        try {
            Session session = HibernateUtil.getSessionFactory();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in create(T o)");
        }

    }

    @Override
    public List<T> read() {
        try {
        Session session = null;
        List<T> list = new ArrayList<T>();
        session = HibernateUtil.getSessionFactory();
        list = session.createCriteria(type).list();
        session.close();
        return list;
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in read()");
        }
    }

    @Override
    public void update(T o) {
        try{
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in update(T o)");
        }
    }

    @Override
    public void delete(T o) {
        try{
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in delete(T o)");
        }
    }

    @Override
    public T readById(long id) {
        try{
        Session session;
        session = HibernateUtil.getSessionFactory();
        T t = (T) session.get(type, id);
        session.close();
        return t;
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in readById(long id)");
        }

    }

    public void deleteById(long id) {
    }

    public List<T> readByClubCatregory(String category, String[] club) {
        return null;
    }

    public T readByNameDelivery(String delivary) {
        return null;
    }

    public T readByNamePayment(String payment) {
        return null;
    }

    public T readByNameStatus(String status) {
        return null;
    }

    public List<T> readOrderedGoodsByStatus(String category) {
        return null;
    }

    public void deleteOrderedGoodsByOrder(Orders order) {
    }

    public List<T> readOrderedGoodsByOrder(long idOrder) {
        return null;
    }

    public T readByNameCategory(String category) {
        return null;
    }

    public T readByNameClub(String club) {
        return null;
    }

}
