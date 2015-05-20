/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.CollectionNames;
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
public class ShowCatalogComand implements ActionCommand {

     private static final Logger log = Logger.getLogger(ShowCatalogComand.class);
     
     
    @Override
    public String execute(HttpServletRequest request) {
      
        String club[];
        String category;
        List<Goods> goodsList;
        try{
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);        
        club = request.getParameterValues(RequestParameters.NAME_CLUB);
        category = CollectionNames.getNameCategoryByKey(request.getParameter(RequestParameters.COMMAND));
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute(RequestAttributes.GOODS_DATA, goodsList);
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttributes.SELECTED_CATEGORY, category);
        session.setAttribute(SessionAttributes.SELECTED_CLUB, club);        
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE); 
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        }

        return Path.CATALOG;
    }

}
