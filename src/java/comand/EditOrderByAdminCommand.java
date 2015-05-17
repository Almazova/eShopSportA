/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;

import model.entity.OrderedGoods;
import model.entity.Orders;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class EditOrderByAdminCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        Orders order = new Orders();
        OrderedGoods orderedGoods = new OrderedGoods();
        List<OrderedGoods> orderedGoodsList = new ArrayList();
        String orderId = request.getParameter("orderId");
        DaoImpl daoImpl = Factory.getInstance().getDAO(order);
        order = (Orders) daoImpl.readById(Long.parseLong(orderId));
        daoImpl = Factory.getInstance().getDAO(orderedGoods);
        orderedGoodsList = daoImpl.readOrderedGoodsByOrder(Long.parseLong(orderId));
        HttpSession session = request.getSession();
        session.setAttribute("orderedGoods", orderedGoodsList);
        session.setAttribute("order", order);
        session.setAttribute("orderId", orderId);
        return "/WEB-INF/view/adminEditOrder.jsp";
    }

}
