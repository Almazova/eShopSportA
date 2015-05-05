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
public class AddedProductToCartCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {

            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        String productId = request.getParameter("goodsId");
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);

        if (!productId.isEmpty()) {
            goods = (Goods) daoImpl.readById(Long.parseLong(productId));
            cart.addItem(goods);
        }
        String page;
        String club[];
        String category;
        List<Goods> goodsList = new ArrayList<Goods>();
        category = (String) session.getAttribute("selectedCategory");
        club = (String[]) session.getAttribute("selectedClub");
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute("data", goodsList);
        request.setAttribute("goodsAdd", productId);
        page = "/WEB-INF/view/DataPage.jsp";
        return page;

    }
}
