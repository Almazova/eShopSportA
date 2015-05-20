/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comand;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import helperclasses.Path;
import helperclasses.RequestParameters;
import helperclasses.SessionAttributes;
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
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author asus
 */
public class NewOrderCommand implements ActionCommand {

    private static final Logger log = Logger.getLogger(NewOrderCommand.class);
    
    @Override
    public String execute(HttpServletRequest request) {
   
        List<OrderedGoods>  orderedGoodsList = new ArrayList();
        String name = request.getParameter(RequestParameters.NAME_CLIENT);
        String surname = request.getParameter(RequestParameters.SURNAME_CLIENT);
        String email = request.getParameter(RequestParameters.EMAIL_CLIENT);
        String phone = request.getParameter(RequestParameters.PHONE_CLIENT);
        String address = request.getParameter(RequestParameters.ADDRESS_CLIENT);
        String delivery = request.getParameter(RequestParameters.NAME_DELIVARY);
        String payment = request.getParameter(RequestParameters.NAME_PAYMENT);

        try{
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
        
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute(SessionAttributes.CART);
        cart.calculateTotal(deliveryMethod.getPriceDm());
        List<ShoppingCartItem> shoppingCartItem = cart.getItems();       
        for (ShoppingCartItem shoppingCartItem1 : shoppingCartItem) {
            OrderedGoods orderedGoods = new OrderedGoods(shoppingCartItem1.getGoods(), 
                    order, shoppingCartItem1.getQuantity(),shoppingCartItem1.getGoods().getPriceGoods());
            daoImpl = Factory.getInstance().getDAO(orderedGoods);
            daoImpl.create(orderedGoods);
            orderedGoodsList.add(orderedGoods);
        }
        session.setAttribute(SessionAttributes.ORDERED_GOODS, orderedGoodsList);
        session.setAttribute(SessionAttributes.TOTAL_SUMMA, cart.getTotal());        
        session.setAttribute(SessionAttributes.LOCATION_OF_SITE, SessionAttributes.WEBSITE);
        cart.clear();
        } catch (NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        } catch (IndexOutOfBoundsException ex) {
            log.error("Exception: " + ex.toString() + ":don't fill in the required fields ");
        } catch (HibernateException ex) {
            log.error("Exception: " + ex.toString());
        } catch (NumberFormatException ex) {
            log.error("Exception: " + ex.toString());
        }
        if(orderedGoodsList.isEmpty())
            return Path.INDEX;
        return Path.READY_ORDER;

    }

}
