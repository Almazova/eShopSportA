/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import cart.ShoppingCart;
import helperclasses.Path;
import helperclasses.SessionAttributes;
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
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
            cart = (ShoppingCart) session.getAttribute(SessionAttributes.CART);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (cart == null) {
            return Path.CART;
        } else if (cart.getNumberOfItems() == 0) {
            return Path.CART;
        }
        return Path.CHECKOUT;
    }

}
