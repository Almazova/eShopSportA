/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

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
public class MarkTheOrderAsInStockCommand implements ActionCommand{
    
    private static final Logger log = Logger.getLogger(MarkTheOrderAsInStockCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        try{
        Goods goods = new Goods();
        String orderId = request.getParameter("goodsId");
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        goods = (Goods) daoImpl.readById(Long.parseLong(orderId));
        goods.setDeleted(false);
        daoImpl.update(goods);
        HttpSession session = request.getSession();
        session.setAttribute("location", "admin");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        return "ServletPage?command=go_to_admin_delete_edit_goods";
    }
}
