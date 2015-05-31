/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bsuir.command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Katya Omelyashchik
 */
public interface ActionCommand {
     String execute(HttpServletRequest request);
}
