/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comand;

import javax.servlet.http.HttpServletRequest;
import model.dao.DaoImpl;
import model.entity.Client;
import model.entity.DeliveryMethod;
import model.entity.Goods;
import model.entity.Orders;
import model.entity.PaymentMethod;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class SaveChangesToTheGoodsCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
  
        String goodsId = request.getParameter("goodsId");
        String name = request.getParameter("nameGoods");
        String price = request.getParameter("price");
        String inf = request.getParameter("inf");       

        Goods goods = new Goods();
        DaoImpl daoImpl = Factory.getInstance().getDAO(goods);        
        goods = (Goods) daoImpl.readById(Long.parseLong(goodsId));
        goods.setInformation(inf);
        goods.setNameGoods(name);
        goods.setPriceGoods(Long.parseLong(price));
        daoImpl.update(goods);       
        
        return "ServletPage?command=go_to_admin_delete_edit_goods";
    }
    
}
