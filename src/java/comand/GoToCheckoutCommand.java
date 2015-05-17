/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class GoToCheckoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) 
            return "/WEB-INF/view/cart.jsp";
        else if (cart.getNumberOfItems() == 0)
            return "/WEB-INF/view/cart.jsp";
        return "/WEB-INF/view/checkout.jsp";
    }

}
