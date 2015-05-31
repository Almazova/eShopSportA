/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsuir.command.generalcommand;

import com.bsuir.command.ActionCommand;
import com.bsuir.helperclasses.Path;
import com.bsuir.helperclasses.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Katya Omelyashchik
 */
public class GoToWebsiteMainPageCommand implements ActionCommand{
    
    private static final Logger log = Logger.getLogger(GoToWebsiteMainPageCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {  
        try{
        HttpSession session = request.getSession();              
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE); 
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }            
        return Path.INDEX;
    }
}
