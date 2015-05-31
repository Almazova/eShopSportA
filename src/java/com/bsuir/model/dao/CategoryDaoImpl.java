/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.dao;

import com.bsuir.model.entity.Category;
import com.bsuir.model.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;



/**
 *
 * @author Katya Omelyashchik
 */
public class CategoryDaoImpl extends DaoImpl{

    public CategoryDaoImpl() {
        super(Category.class);
    }
    @Override
    public Category readByNameCategory(String categoryName) {
        try{
         Category category;
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        category = (Category) session.getNamedQuery("SELECT_BY_CATEGORY_NAME")
                .setString("categoryName", categoryName)                
                .list()
                .get(0);
        return category;
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in readByNameCategory(String categoryName)");
        }
    }
}
