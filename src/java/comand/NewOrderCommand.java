/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.dao.DaoImpl;
import model.entity.Client;
import model.entity.DeliveryMethod;

import model.entity.OrderStatus;
import model.entity.OrderedGoods;
import model.entity.Orders;
import model.entity.PaymentMethod;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class NewOrderCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
   
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String delivery = request.getParameter("delivery");
        String payment = request.getParameter("payment");

        Client client = new Client(surname,name,  email, phone, address);
        DaoImpl daoImpl = Factory.getInstance().getDAO(client);
        daoImpl.create(client);

        DeliveryMethod deliveryMethod = new DeliveryMethod();
        daoImpl = Factory.getInstance().getDAO(deliveryMethod);
        deliveryMethod = (DeliveryMethod) daoImpl.readByNameDelivery(delivery);

        PaymentMethod paymentMethod = new PaymentMethod();
        daoImpl = Factory.getInstance().getDAO(paymentMethod);
        paymentMethod = (PaymentMethod) daoImpl.readByNamePayment(payment);

        OrderStatus orderStatus = new OrderStatus();
        daoImpl = Factory.getInstance().getDAO(orderStatus);
        orderStatus = (OrderStatus) daoImpl.readById(Long.parseLong("1"));

        Date date = new Date();
        Locale local = new Locale("ru", "RU");
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, local);
        df.format(date);

        Orders order = new Orders(df.format(date), client, deliveryMethod, paymentMethod, orderStatus);
        daoImpl = Factory.getInstance().getDAO(order);
        daoImpl.create(order);
//
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart.calculateTotal(deliveryMethod.getPriceDm());
        List<ShoppingCartItem> shoppingCartItem = cart.getItems();
        List<OrderedGoods> orderedGoodsList = new ArrayList();
        for (ShoppingCartItem shoppingCartItem1 : shoppingCartItem) {
            OrderedGoods orderedGoods = new OrderedGoods(shoppingCartItem1.getGoods(), 
                    order, shoppingCartItem1.getQuantity(),shoppingCartItem1.getGoods().getPriceGoods());
            daoImpl = Factory.getInstance().getDAO(orderedGoods);
            daoImpl.create(orderedGoods);
            orderedGoodsList.add(orderedGoods);
        }
        session.setAttribute("orderedGoods", orderedGoodsList);
        session.setAttribute("total", cart.getTotal());
        cart.clear();
        if(orderedGoodsList.isEmpty())
            return "/index.jsp";
        return "/WEB-INF/view/readyOrder.jsp";

    }

}
