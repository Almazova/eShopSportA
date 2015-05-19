/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.ModifOrder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dao.DaoImpl;
import helperclasses.OrderHelp;
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
            orderedGoodsList = daoImpl.readOrderedGoodsByStatus("На обработке");
            ModifOrder modifOrder = new ModifOrder();
            orderHelpList = modifOrder.getModifOrderList(orderedGoodsList);
            request.setAttribute("data", orderHelpList);
            HttpSession session = request.getSession();
            session.setAttribute("location", "admin");
            passwordCheck = (Boolean) session.getAttribute("passwordCheck");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (passwordCheck.booleanValue() == true) {
            return "/WEB-INF/view/adminOrdersReceived.jsp";
        }
        return "/WEB-INF/view/adminPasswordCheck.jsp";

    }

}
