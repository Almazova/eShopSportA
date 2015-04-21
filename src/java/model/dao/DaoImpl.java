/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.utils.HibernateUtil;
import org.hibernate.Session;


/**
 *
 * @author asus
 * @param <T>
 */
public abstract class DaoImpl<T>
        implements Dao<T> {

    private Class<T> type;

    public DaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void create(T o) {
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<T> read() {

        Session session = null;
        List<T> typeTea = new ArrayList<T>();
        session = HibernateUtil.getSessionFactory();
        typeTea = session.createCriteria(type).list();
        session.close();

        return typeTea;
    }

    @Override
    public void update(T o) {
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();       
    }

    @Override
    public void delete(T o) {
        
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();        
    }


    @Override
    public T readById(long id) {
        Session session = null;        
        session = HibernateUtil.getSessionFactory();
        T t = (T) session.get(type,  id);
        session.close();
        return t;
       
    }
     public void deleteById(long id){};
  
}
