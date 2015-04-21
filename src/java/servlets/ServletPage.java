/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CategoryDaoImpl;
import model.dao.ClubDaoImpl;
import model.dao.DaoImpl;
import model.entity.Category;
import model.entity.Club;
import model.entity.Goods;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class ServletPage extends HttpServlet {

    private ServletConfig config;

    // Это наша JSP страница
    String page = "DataPage.jsp";

    @Override
    public void init(ServletConfig config)
            throws ServletException {

        this.config = config;

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
       // String str = (String) request.getAttribute("club");
//       PrintWriter out = response.getWriter();    
//        out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + str + "</h1>");
//            out.println("</body>");
//            out.println("</html>");

        response.setHeader("Content-Type", "text/html; charset=UTF-8");

        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList = daoImpl.read();
        request.setAttribute("data", goodsList);
        // Переходим на JSP страницу
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
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
