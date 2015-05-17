/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

import javax.servlet.http.HttpServletRequest;
import model.dao.DaoImpl;
import model.entity.OrderStatus;
import model.entity.OrderedGoods;
import model.entity.Orders;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class RejectionTheOrderCommand implements ActionCommand {
    
    @Override
    public String execute(HttpServletRequest request) {
        Orders order = new Orders();
        OrderedGoods orderedGoods = new OrderedGoods();
        
        String orderId = request.getParameter("orderId");
        DaoImpl daoImpl = Factory.getInstance().getDAO(order);
        Orders confirmOrder = (Orders) daoImpl.readById(Long.parseLong(orderId));
        daoImpl = Factory.getInstance().getDAO(orderedGoods);
        daoImpl.deleteOrderedGoodsByOrder(confirmOrder);
        daoImpl = Factory.getInstance().getDAO(order);
        
        daoImpl.delete(confirmOrder);
        return "ServletPage?command=go_to_admin_orders_received";
        
    }
    
}
