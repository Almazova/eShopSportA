/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.Goods;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class ShowCatalogComand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String club[];
        String category;
        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        List<Goods> goodsList = new ArrayList<Goods>();
        club = request.getParameterValues("club");
        category = CollectionNames.getNameCategoryByKey(request.getParameter("command"));
        goodsList = daoImpl.readByClubCatregory(category, club);
        request.setAttribute("data", goodsList);
        HttpSession session = request.getSession();
        session.setAttribute("selectedCategory", category);
        session.setAttribute("selectedClub", club);
        page = "/WEB-INF/view/DataPage.jsp";
        // определение пути к main.jsp
        //page = ConfigurationManager.getProperty("path.page.main");

        return page;
    }

}
