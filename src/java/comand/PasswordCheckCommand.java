/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import helperclasses.Password;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author asus
 */
public class PasswordCheckCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(PasswordCheckCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        boolean passwordCheck = false;
        try {
            String pass = request.getParameter("password");
            Password password = new Password();
            passwordCheck = password.passwordCheck(pass);
            HttpSession session = request.getSession();
            session.setAttribute("location", "admin");
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
            session.setAttribute("passwordCheck", true);
            return "/WEB-INF/view/adminMain.jsp";
        } else {
            request.setAttribute("pass", true);
            return "/WEB-INF/view/adminPasswordCheck.jsp";
        }

    }
}
