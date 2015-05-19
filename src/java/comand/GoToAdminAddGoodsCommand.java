/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author asus
 */
public class GoToAdminAddGoodsCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(GoToAdminAddGoodsCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        Boolean passwordCheck = false;
        try {
            HttpSession session = request.getSession();
            session.setAttribute("location", "admin");
            passwordCheck = (Boolean) session.getAttribute("passwordCheck");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (passwordCheck.booleanValue() == true) {
            return "/WEB-INF/view/adminAddGoods.jsp";
        }
        return "/WEB-INF/view/adminPasswordCheck.jsp";

    }

}
