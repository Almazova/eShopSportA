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
public class GoToAdminMainPageCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(GoToAdminMainPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        Boolean passwordCheck = false;
        HttpSession session = null;
        try {
            session = request.getSession();
            session.setAttribute("location", "admin");
            passwordCheck = (Boolean) session.getAttribute("passwordCheck");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (passwordCheck == null) {
            session.setAttribute("passwordCheck", false);
        } else if (passwordCheck.booleanValue()) {
            return "/WEB-INF/view/adminMain.jsp";
        }
        return "/WEB-INF/view/adminPasswordCheck.jsp";
    }

}
