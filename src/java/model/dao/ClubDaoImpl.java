/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.Category;
import model.entity.Club;
import model.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;



/**
 *
 * @author asus
 */
public class ClubDaoImpl extends DaoImpl{

    public ClubDaoImpl() {
        super(Club.class);
    }
    
    @Override
    public Club readByNameClub(String nameClub) {
        try{
        Club club;
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        club = (Club) session.getNamedQuery("SELECT_BY_CLUB_NAME")
                .setString("nameClub", nameClub)                
                .list()
                .get(0);
        return club;
        } catch (HibernateException e) {
            throw new HibernateException("HibernateException in readByNameClub(String nameClub)");
        }
    }
}
