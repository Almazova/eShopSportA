/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.ModifOrder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.dao.DaoImpl;
import model.entity.Goods;
import helperclasses.OrderHelp;
import model.entity.OrderedGoods;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class GoToExecutesOrdersCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        List<OrderedGoods> orderedGoodsList;
        List<OrderHelp> orderHelpList;
        OrderedGoods orderedGoods = new OrderedGoods();

        DaoImpl daoImpl = Factory.getInstance().getDAO(orderedGoods);
        orderedGoodsList = daoImpl.readOrderedGoodsByStatus("Выполняется");
        ModifOrder modifOrder = new ModifOrder();
        orderHelpList = modifOrder.getModifOrderList(orderedGoodsList);

        request.setAttribute("data", orderHelpList);
        return "/WEB-INF/view/adminRejectionOrders.jsp";
    }

}
