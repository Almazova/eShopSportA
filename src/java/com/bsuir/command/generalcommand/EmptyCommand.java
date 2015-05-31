/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.command.generalcommand;

import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.Path;
import com.bsuir.helperclasses.ServletPageCommand;
import com.bsuir.helperclasses.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Katya Omelyashchik
 */
public class EmptyCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(EmptyCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String location = null;
        try {
            HttpSession session = request.getSession();
            location = (String) session.getAttribute(SessionAttributes.LOCATION_OF_SITE);
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (SessionAttributes.ADMINISTRATIVE_PART.equals(location)) {
            return ServletPageCommand.ADMIN_MAIN_PAGE;
        }
        return Path.INDEX;

    }

}
