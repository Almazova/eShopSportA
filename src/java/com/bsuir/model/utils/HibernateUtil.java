/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Katya Omelyashchik
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSessionFactory() {
        return sessionFactory.openSession();
    }

}
