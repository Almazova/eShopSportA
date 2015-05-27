/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command;

import helperclasses.Path;
import helperclasses.RequestAttributes;
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
public class EditGoodsByAdminCommand implements ActionCommand{

    private static final Logger log = Logger.getLogger(EditGoodsByAdminCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        try{
        Goods goods = new Goods();   
        String goodsId = request.getParameter(RequestParameters.GOODS_ID);
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));        
        request.setAttribute(RequestAttributes.GOODS, goods);
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }  catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        return Path.ADMIN_EDIT_GOODS;       
    }
    
}
