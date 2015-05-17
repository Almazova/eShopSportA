/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @Column(name = "date_order")
    private String dateOrder;   

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "dm_id")    
    private DeliveryMethod deliveryMethod;
    
    @ManyToOne
    @JoinColumn(name = "pm_id")
    private PaymentMethod paymentMethod;
    
    @ManyToOne
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
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.ordersId != null ? this.ordersId.hashCode() : 0);
        hash = 41 * hash + (this.dateOrder != null ? this.dateOrder.hashCode() : 0);      
        hash = 41 * hash + (this.client != null ? this.client.hashCode() : 0);
        hash = 41 * hash + (this.deliveryMethod != null ? this.deliveryMethod.hashCode() : 0);
        hash = 41 * hash + (this.paymentMethod != null ? this.paymentMethod.hashCode() : 0);
        hash = 41 * hash + (this.orderStatus != null ? this.orderStatus.hashCode() : 0);
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
        if (this.ordersId != other.ordersId && (this.ordersId == null || !this.ordersId.equals(other.ordersId))) {
            return false;
        }
        if ((this.dateOrder == null) ? (other.dateOrder != null) : !this.dateOrder.equals(other.dateOrder)) {
            return false;
        }       
        if (this.client != other.client && (this.client == null || !this.client.equals(other.client))) {
            return false;
        }
        if (this.deliveryMethod != other.deliveryMethod && (this.deliveryMethod == null || !this.deliveryMethod.equals(other.deliveryMethod))) {
            return false;
        }
        if (this.paymentMethod != other.paymentMethod && (this.paymentMethod == null || !this.paymentMethod.equals(other.paymentMethod))) {
            return false;
        }
        if (this.orderStatus != other.orderStatus && (this.orderStatus == null || !this.orderStatus.equals(other.orderStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orders{" + "ordersId=" + ordersId + ", dateOrder=" + dateOrder + ",  client=" + client + ", deliveryMethod=" + deliveryMethod + ", paymentMethod=" + paymentMethod + ", orderStatus=" + orderStatus + '}';
    }

    
    
}
