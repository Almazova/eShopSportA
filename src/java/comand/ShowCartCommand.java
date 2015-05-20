/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

import helperclasses.Path;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author asus
 */
public class ShowCartCommand implements ActionCommand{

    private static final Logger log = Logger.getLogger(ShowCartCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
        try{
        HttpSession session = request.getSession();
        session.setAttribute("location", "website");
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }
        return Path.CART;
    }
    
}
