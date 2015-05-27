/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import helperclasses.RequestAttributes;
import helperclasses.RequestParameters;
import helperclasses.ServletPageCommand;
import helperclasses.SessionAttributes;
import java.util.List;
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
public class UpdateQuantityByAdminCommand implements ActionCommand {

     private static final Logger log = Logger.getLogger(UpdateQuantityByAdminCommand.class);
     
    @Override
    public String execute(HttpServletRequest request) {
        List <OrderedGoods> orderedGoodsList;
        String orderId = null;
        try{
        OrderedGoods orderedGoods = new OrderedGoods();
        Orders order = new Orders();       
        String orderedGoodId = request.getParameter(RequestParameters.GOODS_ID);
        String quantity = request.getParameter(RequestParameters.QUANTITY);
        DaoImpl daoImpl = Factory.getInstance().getDAO(orderedGoods);
        if(Integer.parseInt(quantity) == 0){
            orderedGoods = (OrderedGoods) daoImpl.readById(Long.parseLong(orderedGoodId));
             daoImpl.delete(orderedGoods);
            orderedGoodsList = daoImpl.readOrderedGoodsByOrder(orderedGoods.getOrder().getOrdersId());
           
            if(orderedGoodsList.isEmpty()){
                daoImpl = Factory.getInstance().getDAO(order);
                daoImpl.delete(orderedGoods.getOrder());
            }     
        }
        else{
            orderedGoods = (OrderedGoods) daoImpl.readById(Long.parseLong(orderedGoodId));
            orderedGoods.setAmount(Integer.parseInt(quantity));
            daoImpl.update(orderedGoods);
        }      
        HttpSession session = request.getSession();        
        request.setAttribute(RequestAttributes.ORDER_ID,session.getAttribute(SessionAttributes.ORDER_ID));        
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
         orderId = (String)session.getAttribute(SessionAttributes.ORDER_ID);
         } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        return ServletPageCommand.ADMIN_ORDER_EDIT_BY_ORDERID + orderId;       
    }

}
