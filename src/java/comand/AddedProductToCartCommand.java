/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import helperclasses.Path;
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
            if (!goods.isDeleted()) {
                cart.addItem(goods);
            }
        }

        
        category = (String) session.getAttribute("selectedCategory");
        club = (String[]) session.getAttribute("selectedClub");
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute("data", goodsList);
        request.setAttribute("goodsAdd", productId);
        session.setAttribute("location", "website");
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
