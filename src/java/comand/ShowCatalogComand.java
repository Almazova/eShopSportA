/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.CollectionNames;
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
        club = request.getParameterValues("club");
        category = CollectionNames.getNameCategoryByKey(request.getParameter("command"));
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute("data", goodsList);
        HttpSession session = request.getSession();
        session.setAttribute("selectedCategory", category);
        session.setAttribute("selectedClub", club);        
        session.setAttribute("location", "website"); 
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
