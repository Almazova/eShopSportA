/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

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
public class ContinuedCatalogViewCommand implements ActionCommand{

    private static final Logger log = Logger.getLogger(ContinuedCatalogViewCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
       try{
        String club[];
        String category;
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        List<Goods> goodsList;
        HttpSession session = request.getSession();
        category = (String) session.getAttribute("selectedCategory");
        club = (String[]) session.getAttribute("selectedClub");       
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute("data", goodsList);       
        session.setAttribute("location", "website");
         } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());        
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
             
        return "/WEB-INF/view/catalog.jsp";
    }
    
}
