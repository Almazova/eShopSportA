/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command.clientsitecommand;

import cart.ShoppingCart;
import command.ActionCommand;
import helperclasses.Path;
import helperclasses.RequestParameters;
import helperclasses.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.Goods;
import model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author asus
 */
public class DeleteGoodsFromCartCommand implements ActionCommand{
    
    private static final Logger log = Logger.getLogger(DeleteGoodsFromCartCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        try{
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute(SessionAttributes.CART);      
        String goodsId = request.getParameter(RequestParameters.GOODS_ID);       
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));
        cart.update(goods, "0");        
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
         } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());        
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }

        return Path.CART;
    }
}
