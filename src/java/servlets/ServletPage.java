/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import comand.ActionCommand;
import comand.ActionFactory;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author asus
 */
public class ServletPage extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        String homeDir = config.getServletContext().getRealPath("/");
        File propertiesFile = new File(homeDir, "/log4j.properties");
        PropertyConfigurator.configure(propertiesFile.toString());

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        String page;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {

            // установка страницы c cообщением об ошибке
//            page = ConfigurationManager.getProperty("path.page.index");
//            request.getSession().setAttribute("nullPage",
//                    MessageManager.getProperty("message.nullpage"));
//            response.sendRedirect(request.getContextPath() + page);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
