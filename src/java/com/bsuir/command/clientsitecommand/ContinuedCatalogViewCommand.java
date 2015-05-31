/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsuir.command.clientsitecommand;

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
public class ContinuedCatalogViewCommand implements ActionCommand{

    private static final Logger log = Logger.getLogger(ContinuedCatalogViewCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
       try{
        String club[];
        String category;
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        List<Goods> goodsList;
        HttpSession session = request.getSession();
        category = (String) session.getAttribute(SessionAttributes.SELECTED_CATEGORY);
        club = (String[]) session.getAttribute(SessionAttributes.SELECTED_CLUB);       
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute(RequestAttributes.GOODS_DATA, goodsList);       
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
         } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());        
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
             
        return Path.CATALOG;
    }
    
}
