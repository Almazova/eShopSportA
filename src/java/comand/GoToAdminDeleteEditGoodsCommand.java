/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.ModifOrder;
import helperclasses.OrderHelp;
import java.util.List;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import model.dao.DaoImpl;
import model.entity.Goods;
import model.entity.OrderedGoods;
import model.entity.Orders;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class GoToAdminDeleteEditGoodsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        List<Goods> goodsList;
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        goodsList = daoImpl.read();
        request.setAttribute("data", goodsList);
        return "/WEB-INF/view/adminDeleteEditGoods.jsp";
    }

}
