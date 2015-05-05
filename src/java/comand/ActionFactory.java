/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author asus
 */
public class ActionFactory {

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
//            request.setAttribute("wrongAction", action
//                    + MessageManager.getProperty("message.wrongaction") 

        }
        return current;
    }

}
