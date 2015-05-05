/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long ordersId;

    @Column(name = "name_goods")
    private String dateOrder;   

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dm_id")
    private DeliveryMethod deliveryMethod;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pm_id")
    private PaymentMethod paymentMethod;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;   

    public Orders() {
    }

    public Orders(String dateOrder, Client client, DeliveryMethod deliveryMethod, PaymentMethod paymentMethod, OrderStatus orderStatus) {
        this.dateOrder = dateOrder;
        this.client = client;
        this.deliveryMethod = deliveryMethod;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "ordersId=" + ordersId + ", dateOrder=" + dateOrder + ", client=" + client + ", deliveryMethod=" + deliveryMethod + ", paymentMethod=" + paymentMethod + ", orderStatus=" + orderStatus + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.ordersId);
        hash = 79 * hash + Objects.hashCode(this.dateOrder);
        hash = 79 * hash + Objects.hashCode(this.client);
        hash = 79 * hash + Objects.hashCode(this.deliveryMethod);
        hash = 79 * hash + Objects.hashCode(this.paymentMethod);
        hash = 79 * hash + Objects.hashCode(this.orderStatus);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orders other = (Orders) obj;
        if (!Objects.equals(this.ordersId, other.ordersId)) {
            return false;
        }
        if (!Objects.equals(this.dateOrder, other.dateOrder)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.deliveryMethod, other.deliveryMethod)) {
            return false;
        }
        if (!Objects.equals(this.paymentMethod, other.paymentMethod)) {
            return false;
        }
        if (!Objects.equals(this.orderStatus, other.orderStatus)) {
            return false;
        }
        return true;
    }
    
    
    
}
