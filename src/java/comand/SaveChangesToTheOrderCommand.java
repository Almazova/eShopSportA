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
import model.entity.Orders;
import model.entity.PaymentMethod;
import model.factory.Factory;

/**
 *
 * @author asus
 */
public class SaveChangesToTheOrderCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
   
        String idClient = request.getParameter("clientId");
        String idOrder = request.getParameter("ordersId");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String delivery = request.getParameter("delivery");
        String payment = request.getParameter("payment");

        Client client = new Client();
        DaoImpl daoImpl = Factory.getInstance().getDAO(client);        
        client = (Client) daoImpl.readById(Long.parseLong(idClient));
        client.setNameClient(name);
        client.setSurnameClient(surname);
        client.setEmailClient(email);
        client.setPhoneClient(phone);
        client.setAddressClient(address);
        daoImpl.update(client);

        DeliveryMethod deliveryMethod = new DeliveryMethod();
        daoImpl = Factory.getInstance().getDAO(deliveryMethod);
        deliveryMethod = (DeliveryMethod) daoImpl.readByNameDelivery(delivery);

        PaymentMethod paymentMethod = new PaymentMethod();
        daoImpl = Factory.getInstance().getDAO(paymentMethod);
        paymentMethod = (PaymentMethod) daoImpl.readByNamePayment(payment);
       

        Orders order = new Orders();
        daoImpl = Factory.getInstance().getDAO(order);
        order = (Orders) daoImpl.readById(Long.parseLong(idOrder));
        order.setClient(client);
        order.setDeliveryMethod(deliveryMethod);
        order.setPaymentMethod(paymentMethod);
        daoImpl.update(order);
        
        return "ServletPage?command=go_to_admin_orders_received";
    }

}
