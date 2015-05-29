/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.clientsitecommand;

import cart.ShoppingCart;
import command.ActionCommand;
import helperclasses.Path;
import helperclasses.RequestAttributes;
import helperclasses.RequestParameters;
import helperclasses.SessionAttributes;
import java.util.List;
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
public class AddedProductToCartCommand implements ActionCommand {

     private static final Logger log = Logger.getLogger(AddedProductToCartCommand.class);
     
    @Override
    public String execute(HttpServletRequest request) {
       try{
        String club[];
        String category;
        List<Goods> goodsList;
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute(SessionAttributes.CART);
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute(SessionAttributes.CART, cart);
        }
        String goodsId = request.getParameter(RequestParameters.GOODS_ID);
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);

        if (!goodsId.isEmpty()) {
            goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));
            if (!goods.isDeleted()) {
                cart.addItem(goods);
            }
        }
        
        category = (String) session.getAttribute(SessionAttributes.SELECTED_CATEGORY);
        club = (String[]) session.getAttribute(SessionAttributes.SELECTED_CLUB);
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute(RequestAttributes.GOODS_DATA, goodsList);
        request.setAttribute(RequestAttributes.GOODS_ID_ADD, goodsId);
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        }
        return Path.CATALOG;

    }
}
