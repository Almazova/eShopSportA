/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.command.generalcommand;

import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.Password;
import com.bsuir.helperclasses.Path;
import com.bsuir.helperclasses.RequestAttributes;
import com.bsuir.helperclasses.RequestParameters;
import com.bsuir.helperclasses.SessionAttributes;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Katya Omelyashchik
 */
public class PasswordCheckCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(PasswordCheckCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        boolean passwordCheck = false;
        try {
            String pass = request.getParameter(RequestParameters.PASSWORD);
            Password password = new Password();
            passwordCheck = password.passwordCheck(pass);
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.ADMINISTRATIVE_PART);
        } catch (ParserConfigurationException exception) {
            log.error("Exception: " + exception.toString());
        } catch (SAXException exception) {
            log.error("Exception: " + exception.toString());
        } catch (IOException exception) {
            log.error("Exception: " + exception.toString());
        } catch (DOMException exception) {
            log.error("Exception: " + exception.toString());
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }
        if (passwordCheck) {
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttributes.PASSWORD_CHECK, true);
            return Path.ADMIN_MAIN;
        } else {
            request.setAttribute(RequestAttributes.PASSWORD_IS_NOT_CORRECT, true);
            return Path.ADMIN_PASSWORD_CHECK;
        }

    }
}
