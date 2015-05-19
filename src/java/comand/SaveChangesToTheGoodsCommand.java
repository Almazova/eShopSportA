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
public class SaveChangesToTheGoodsCommand implements ActionCommand{

    private static final Logger log = Logger.getLogger(SaveChangesToTheGoodsCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
  
        try{
        String goodsId = request.getParameter("goodsId");
        String name = request.getParameter("nameGoods");
        String price = request.getParameter("price");
        String inf = request.getParameter("inf");       

        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);        
        goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));
        goods.setInformation(inf);
        goods.setNameGoods(name);
        goods.setPriceGoods(Long.parseLong(price));
        daoImpl.update(goods);       
        HttpSession session = request.getSession();        
        session.setAttribute("location", "admin");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        }
        return "ServletPage?command=go_to_admin_delete_edit_goods";
    }
    
}
