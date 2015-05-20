/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.Path;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.Category;
import model.entity.Club;
import model.entity.Goods;
import model.factory.Factory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author asus
 */
public class AddGoodsByAdminCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(AddGoodsByAdminCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        try {
            String nameGoods = request.getParameter("nameGoods");
            String image = request.getParameter("img");
            String categoryName = request.getParameter("category");
            String clubName = request.getParameter("club");
            String price = request.getParameter("price");
            String inf = request.getParameter("inf");

            Category category = new Category();
            DaoImpl daoImpl = Factory.getInstance().getDAO(category);
            category = (Category) daoImpl.readByNameCategory(categoryName);

            Club club = new Club();
            daoImpl = Factory.getInstance().getDAO(club);
            club = (Club) daoImpl.readByNameClub(clubName);

            Goods goods = new Goods(nameGoods, Long.parseLong(price), inf, image, category, club);
            daoImpl = Factory.getInstance().getDAO(goods);
            daoImpl.create(goods);

            request.setAttribute("added", true);
            HttpSession session = request.getSession();
            session.setAttribute("location", "website");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString()+ ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());        
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
}
        return Path.ADMIN_ADD_GOODS;
    }

}
