/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

import javax.servlet.http.HttpServletRequest;
import model.dao.DaoImpl;
import model.entity.Goods;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class MarkTheOrderAsInStockCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        Goods goods = new Goods();
        String orderId = request.getParameter("goodsId");
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);
        goods = (Goods) daoImpl.readById(Long.parseLong(orderId));
        goods.setDeleted(false);
        daoImpl.update(goods);
        return "ServletPage?command=go_to_admin_delete_edit_goods";
    }
}
