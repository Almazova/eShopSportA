/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.command.clientsitecommand;

import com.bsuir.cart.ShoppingCart;
import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.Path;
import com.bsuir.helperclasses.RequestAttributes;
import com.bsuir.helperclasses.RequestParameters;
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
public class AddedProductToCartCommand implements ActionCommand {

     private static final Logger log = Logger.getLogger(AddedProductToCartCommand.class);
     
    @Override
    public String execute(HttpServletRequest request) {
       try{
        String club[];
        String category;
        List<Goods> goodsList;
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute(SessionAttributes.CART);
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute(SessionAttributes.CART, cart);
        }
        String goodsId = request.getParameter(RequestParameters.GOODS_ID);
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);

        if (!goodsId.isEmpty()) {
            goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));
            if (!goods.isDeleted()) {
                cart.addItem(goods);
            }
        }
        
        category = (String) session.getAttribute(SessionAttributes.SELECTED_CATEGORY);
        club = (String[]) session.getAttribute(SessionAttributes.SELECTED_CLUB);
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute(RequestAttributes.GOODS_DATA, goodsList);
        request.setAttribute(RequestAttributes.GOODS_ID_ADD, goodsId);
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        }
        return Path.CATALOG;

    }
}
