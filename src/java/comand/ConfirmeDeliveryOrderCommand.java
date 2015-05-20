/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.OtherParameters;
import helperclasses.Path;
import helperclasses.RequestParameters;
import helperclasses.ServletPageCommand;
import helperclasses.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.OrderStatus;
import model.entity.Orders;
import model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author asus
 */
public class ConfirmeDeliveryOrderCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(ConfirmeDeliveryOrderCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        try{
        Orders order = new Orders();
        OrderStatus orderStatus = new OrderStatus();
        String orderId = request.getParameter(RequestParameters.ORDER_ID);
        DaoImpl daoImpl = Factory.getInstance().getDAO(order);
        Orders confirmOrder = (Orders) daoImpl.readById(Long.parseLong(orderId));
        daoImpl = Factory.getInstance().getDAO(orderStatus);
        orderStatus = (OrderStatus) daoImpl.readByNameStatus(OtherParameters.STATUS_DELIVERED);
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
