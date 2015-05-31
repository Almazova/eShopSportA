/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsuir.command.admincommand;

import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.OtherParameters;
import com.bsuir.helperclasses.RequestParameters;
import com.bsuir.helperclasses.ServletPageCommand;
import com.bsuir.helperclasses.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bsuir.model.dao.DaoImpl;
import com.bsuir.model.entity.OrderStatus;
import com.bsuir.model.entity.Orders;
import com.bsuir.model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Katya Omelyashchik
 */
public class RejectionDeliveryOfOrderCommand implements ActionCommand{

    private static final Logger log = Logger.getLogger(RejectionDeliveryOfOrderCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        try{
        Orders order = new Orders();
        OrderStatus orderStatus = new OrderStatus();
        String orderId = request.getParameter(RequestParameters.ORDER_ID);
        DaoImpl daoImpl = Factory.getInstance().getDAO(order);
        Orders confirmOrder = (Orders) daoImpl.readById(Long.parseLong(orderId));
        daoImpl = Factory.getInstance().getDAO(orderStatus);
        orderStatus = (OrderStatus) daoImpl.readByNameStatus(OtherParameters.STATUS_NOT_DELIVERED);
        confirmOrder.setOrderStatus(orderStatus);
        daoImpl = Factory.getInstance().getDAO(order);
        daoImpl.update(confirmOrder);
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
        return ServletPageCommand.EXECUTES_ORDERS;
    }
    
}
