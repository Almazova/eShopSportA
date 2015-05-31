/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.command.admincommand;

import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.Path;
import com.bsuir.helperclasses.RequestAttributes;
import com.bsuir.helperclasses.SessionAttributes;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bsuir.model.dao.DaoImpl;
import com.bsuir.model.entity.Goods;
import com.bsuir.model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Katya Omelyashchik
 */
public class GoToAdminDeleteEditGoodsCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(GoToAdminDeleteEditGoodsCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        List<Goods> goodsList;
        Boolean passwordCheck = false;
        try {
            Goods goods = new Goods();
            HttpSession session = request.getSession();
            DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
            goodsList = daoImpl.read();
            request.setAttribute(RequestAttributes.GOODS_DATA, goodsList);
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
            passwordCheck = (Boolean) session.getAttribute(SessionAttributes.PASSWORD_CHECK);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (passwordCheck.booleanValue() == true) {
            return Path.ADMIN_DELETE_EDIT_GOODS;
        }
        return Path.ADMIN_PASSWORD_CHECK;

    }

}
