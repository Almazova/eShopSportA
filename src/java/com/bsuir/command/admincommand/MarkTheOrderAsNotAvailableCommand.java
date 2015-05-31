/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsuir.command.admincommand;
import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.RequestParameters;
import com.bsuir.helperclasses.ServletPageCommand;
import com.bsuir.helperclasses.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bsuir.model.dao.DaoImpl;
import com.bsuir.model.entity.Goods;
import com.bsuir.model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Katya Omelyashchik
 */
public class MarkTheOrderAsNotAvailableCommand implements ActionCommand{
    
    private static final Logger log = Logger.getLogger(MarkTheOrderAsNotAvailableCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        try{
        Goods goods = new Goods();
        String orderId = request.getParameter(RequestParameters.GOODS_ID);
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        goods = (Goods) daoImpl.readById(Long.parseLong(orderId));
        goods.setDeleted(true);
        daoImpl.update(goods);
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        return ServletPageCommand.ADMIN_DELETE_EDIT_GOODS;
    }
    
}
