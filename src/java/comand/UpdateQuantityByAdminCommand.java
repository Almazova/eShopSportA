/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.Goods;
import model.entity.OrderedGoods;
import model.entity.Orders;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class UpdateQuantityByAdminCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        OrderedGoods orderedGoods = new OrderedGoods();
        Orders order = new Orders();
       List <OrderedGoods> orderedGoodsList = new ArrayList();
        String orderedGoodId = request.getParameter("goodsId");
        String quantity = request.getParameter("quantity");
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
        request.setAttribute("orderId",session.getAttribute("orderId"));
        String orderId = (String)session.getAttribute("orderId");
        return "ServletPage?command=edit_order_by_admin&orderId=" + orderId;       
    }

}
