/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsuir.command.admincommand;

import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.RequestParameters;
import com.bsuir.helperclasses.ServletPageCommand;
import com.bsuir.helperclasses.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bsuir.model.dao.DaoImpl;
import com.bsuir.model.entity.OrderedGoods;
import com.bsuir.model.entity.Orders;
import com.bsuir.model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Katya Omelyashchik
 */
public class RejectionTheOrderCommand implements ActionCommand {
    
     private static final Logger log = Logger.getLogger(RejectionTheOrderCommand.class);
     
    @Override
    public String execute(HttpServletRequest request) {
        try{
        Orders order = new Orders();
        OrderedGoods orderedGoods = new OrderedGoods();        
        String orderId = request.getParameter(RequestParameters.ORDER_ID);
        DaoImpl daoImpl = Factory.getInstance().getDAO(order);
        Orders confirmOrder = (Orders) daoImpl.readById(Long.parseLong(orderId));
        daoImpl = Factory.getInstance().getDAO(orderedGoods);
        daoImpl.deleteOrderedGoodsByOrder(confirmOrder);
        daoImpl = Factory.getInstance().getDAO(order);        
        daoImpl.delete(confirmOrder);
        HttpSession session = request.getSession();        
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        return ServletPageCommand.ADMIN_ORDERS_RECEIVED;
        
    }
    
}
