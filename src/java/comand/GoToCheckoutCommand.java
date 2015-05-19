/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author asus
 */
public class GoToCheckoutCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(GoToCheckoutCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        ShoppingCart cart = null;
        try {
            HttpSession session = request.getSession();
            session.setAttribute("location", "admin");
            session.setAttribute("location", "website");
            cart = (ShoppingCart) session.getAttribute("cart");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (cart == null) {
            return "/WEB-INF/view/cart.jsp";
        } else if (cart.getNumberOfItems() == 0) {
            return "/WEB-INF/view/cart.jsp";
        }
        return "/WEB-INF/view/checkout.jsp";
    }

}
