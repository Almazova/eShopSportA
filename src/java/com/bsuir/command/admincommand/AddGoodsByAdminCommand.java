/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.command.admincommand;

import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.Path;
import com.bsuir.helperclasses.RequestAttributes;
import com.bsuir.helperclasses.RequestParameters;
import com.bsuir.helperclasses.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bsuir.model.dao.DaoImpl;
import com.bsuir.model.entity.Category;
import com.bsuir.model.entity.Club;
import com.bsuir.model.entity.Goods;
import com.bsuir.model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Katya Omelyashchik
 */
public class AddGoodsByAdminCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(AddGoodsByAdminCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        try {
            String nameGoods = request.getParameter(RequestParameters.NAME_GOODS);
            String image = request.getParameter(RequestParameters.PATH_IMG);
            String categoryName = request.getParameter(RequestParameters.NAME_CATEGORY);
            String clubName = request.getParameter(RequestParameters.NAME_CLUB);
            String price = request.getParameter(RequestParameters.PRICE);
            String inf = request.getParameter(RequestParameters.INFORMATION);

            Category category = new Category();
            DaoImpl daoImpl = Factory.getInstance().getDAO(category);
            category = (Category) daoImpl.readByNameCategory(categoryName);

            Club club = new Club();
            daoImpl = Factory.getInstance().getDAO(club);
            club = (Club) daoImpl.readByNameClub(clubName);

            Goods goods = new Goods(nameGoods, Long.parseLong(price), inf, image, category, club);
            daoImpl = Factory.getInstance().getDAO(goods);
            daoImpl.create(goods);

            request.setAttribute(RequestAttributes.GOODS_ADDED, true);
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString()+ ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());        
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
}
        return Path.ADMIN_ADD_GOODS;
    }

}
