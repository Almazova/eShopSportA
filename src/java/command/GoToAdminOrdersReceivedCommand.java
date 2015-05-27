/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import helperclasses.ModifOrder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dao.DaoImpl;
import helperclasses.OrderHelp;
import helperclasses.OtherParameters;
import helperclasses.Path;
import helperclasses.RequestAttributes;
import helperclasses.SessionAttributes;
import javax.servlet.http.HttpSession;
import model.entity.OrderedGoods;
import model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author asus
 */
public class GoToAdminOrdersReceivedCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(GoToAdminOrdersReceivedCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        List<OrderedGoods> orderedGoodsList;
        List<OrderHelp> orderHelpList;
        Boolean passwordCheck = false;
        try {
            OrderedGoods orderedGoods = new OrderedGoods();
            DaoImpl daoImpl = Factory.getInstance().getDAO(orderedGoods);
            orderedGoodsList = daoImpl.readOrderedGoodsByStatus(OtherParameters.STATUS_IN_PROCESSING);
            ModifOrder modifOrder = new ModifOrder();
            orderHelpList = modifOrder.getModifOrderList(orderedGoodsList);
            request.setAttribute(RequestAttributes.ORDER_DATA, orderHelpList);
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
            passwordCheck = (Boolean) session.getAttribute(SessionAttributes.PASSWORD_CHECK);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (passwordCheck.booleanValue() == true) {
            return Path.ADMIN_ORDERS_RECEIVED;
        }
        return Path.ADMIN_PASSWORD_CHECK;

    }

}
