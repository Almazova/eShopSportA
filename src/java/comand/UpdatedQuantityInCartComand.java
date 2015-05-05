/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.Goods;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class UpdatedQuantityInCartComand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        // get user input from request
        String productId = request.getParameter("goodsId");
        String quantity = request.getParameter("quantity");
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);

        goods = (Goods) daoImpl.readById(Long.parseLong(productId));
        cart.update(goods, quantity);      

        return "/WEB-INF/view/cart.jsp";
    }
}
