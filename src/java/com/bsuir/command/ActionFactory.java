/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.command;

import com.bsuir.command.generalcommand.EmptyCommand;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author Katya Omelyashchik
 */
public class ActionFactory {

     private static final Logger log = Logger.getLogger(ActionFactory.class);
     
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {            
            return current;
        }        
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            log.error("Exception: " + e.toString());
        }
        return current;
    }

}
