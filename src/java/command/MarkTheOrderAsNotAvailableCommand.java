/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command;
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
