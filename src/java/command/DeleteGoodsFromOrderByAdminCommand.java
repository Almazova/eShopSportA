/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import helperclasses.Path;
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
public class DeleteGoodsFromOrderByAdminCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(DeleteGoodsFromOrderByAdminCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String orderId = "";
        List<OrderedGoods> orderedGoodsList;
        try {
            OrderedGoods orderedGoods = new OrderedGoods();            
            Orders order = new Orders();
            String orderedGoodId = request.getParameter(RequestParameters.GOODS_ID);
            DaoImpl daoImpl = Factory.getInstance().getDAO(orderedGoods);
            orderedGoods = (OrderedGoods) daoImpl.readById(Long.parseLong(orderedGoodId));
            daoImpl.delete(orderedGoods);
            orderedGoodsList = daoImpl.readOrderedGoodsByOrder(orderedGoods.getOrder().getOrdersId());

            if (orderedGoodsList.isEmpty()) {
                daoImpl = Factory.getInstance().getDAO(order);
                daoImpl.delete(orderedGoods.getOrder());
            }

            HttpSession session = request.getSession();
            request.setAttribute(RequestAttributes.ORDER_ID, session.getAttribute(SessionAttributes.ORDER_ID));
            orderId = (String) session.getAttribute(SessionAttributes.ORDER_ID);
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        return ServletPageCommand.ADMIN_ORDER_EDIT_BY_ORDERID + orderId;
    }

}
