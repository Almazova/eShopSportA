/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.OrderedGoods;
import model.entity.Orders;
import model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author asus
 */
public class RejectionTheOrderCommand implements ActionCommand {
    
     private static final Logger log = Logger.getLogger(RejectionTheOrderCommand.class);
     
    @Override
    public String execute(HttpServletRequest request) {
        try{
        Orders order = new Orders();
        OrderedGoods orderedGoods = new OrderedGoods();        
        String orderId = request.getParameter("orderId");
        DaoImpl daoImpl = Factory.getInstance().getDAO(order);
        Orders confirmOrder = (Orders) daoImpl.readById(Long.parseLong(orderId));
        daoImpl = Factory.getInstance().getDAO(orderedGoods);
        daoImpl.deleteOrderedGoodsByOrder(confirmOrder);
        daoImpl = Factory.getInstance().getDAO(order);        
        daoImpl.delete(confirmOrder);
        HttpSession session = request.getSession();        
        session.setAttribute("location", "admin");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        return "ServletPage?command=go_to_admin_orders_received";
        
    }
    
}
