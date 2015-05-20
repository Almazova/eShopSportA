/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import helperclasses.Path;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author asus
 */
public class CleaningCartCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(CleaningCartCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            cart.clear();
            session.setAttribute("location", "website");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }
        return Path.CART;

    }
}
