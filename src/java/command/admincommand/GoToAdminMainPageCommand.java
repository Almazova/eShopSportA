/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.admincommand;

import command.ActionCommand;
import helperclasses.Path;
import helperclasses.SessionAttributes;
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
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
            passwordCheck = (Boolean) session.getAttribute(SessionAttributes.PASSWORD_CHECK);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (passwordCheck == null) {
            session.setAttribute(SessionAttributes.PASSWORD_CHECK, false);
        } else if (passwordCheck.booleanValue()) {
            return Path.ADMIN_MAIN;
        }
        return Path.ADMIN_PASSWORD_CHECK;
    }

}
