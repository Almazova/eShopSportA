/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.entity.Goods;
import model.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author asus
 */
public class GoodsDaoImpl extends DaoImpl {

    public GoodsDaoImpl() {
        super(Goods.class);
    }

    @Override
    public void deleteById(long id) {
        delete(readById(id));
    }

    @Override
    public List<Goods> readByClubCatregory(String category, String[] club) {
        List<Goods> goods = new ArrayList<Goods>();
        Session session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        if (club == null) {
            goods = session.getNamedQuery("SELECT_BY_CATEGORY")
                    .setString("nameCategory", category)
                    .list();
        } else if (club.length == 1) {
            goods = session.getNamedQuery("SELECT_BY_ONE_CLUB_AND_CATEGORY")
                    .setString("nameCategory", category)
                    .setString("nameClub1", club[0])
                    .list();
        } else if (club.length == 2) {
            goods = session.getNamedQuery("SELECT_BY_TWO_CLUB_AND_CATEGORY")
                    .setString("nameCategory", category)
                    .setString("nameClub1", club[0])
                    .setString("nameClub2", club[1])
                    .list();

        } else {
            goods = session.getNamedQuery("SELECT_BY_TREE_CLUB_AND_CATEGORY")
                    .setString("nameCategory", category)
                    .setString("nameClub1", club[0])
                    .setString("nameClub2", club[1])
                    .setString("nameClub3", club[2])
                    .list();

        }
        session.close();
        return goods;
    }

}
