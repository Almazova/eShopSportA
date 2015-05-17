/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.Goods;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class DeleteGoodsFromCartCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
      
        String productId = request.getParameter("goodsId");       
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);

        goods = (Goods) daoImpl.readById(Long.parseLong(productId));
        cart.update(goods, "0");      

        return "/WEB-INF/view/cart.jsp";
    }
}
