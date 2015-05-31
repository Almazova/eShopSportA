/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsuir.command.clientsitecommand;

import com.bsuir.cart.ShoppingCart;
import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.Path;
import com.bsuir.helperclasses.RequestParameters;
import com.bsuir.helperclasses.SessionAttributes;
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
public class DeleteGoodsFromCartCommand implements ActionCommand{
    
    private static final Logger log = Logger.getLogger(DeleteGoodsFromCartCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        try{
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute(SessionAttributes.CART);      
        String goodsId = request.getParameter(RequestParameters.GOODS_ID);       
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));
        cart.update(goods, "0");        
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
         } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());        
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }

        return Path.CART;
    }
}
