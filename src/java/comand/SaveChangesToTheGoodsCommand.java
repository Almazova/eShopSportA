/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

import helperclasses.RequestParameters;
import helperclasses.ServletPageCommand;
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
public class SaveChangesToTheGoodsCommand implements ActionCommand{

    private static final Logger log = Logger.getLogger(SaveChangesToTheGoodsCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
  
        try{
        String goodsId = request.getParameter(RequestParameters.GOODS_ID);
        String name = request.getParameter(RequestParameters.NAME_GOODS);
        String price = request.getParameter(RequestParameters.PRICE);
        String inf = request.getParameter(RequestParameters.INFORMATION);       

        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);        
        goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));
        goods.setInformation(inf);
        goods.setNameGoods(name);
        goods.setPriceGoods(Long.parseLong(price));
        daoImpl.update(goods);       
        HttpSession session = request.getSession();        
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        }
        return ServletPageCommand.ADMIN_DELETE_EDIT_GOODS;
    }
    
}
