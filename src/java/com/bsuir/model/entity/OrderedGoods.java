/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 *
 * @author Katya Omelyashchik
 */
@Entity
@Table(name = "ordered_good")
@NamedQueries({
    @NamedQuery(name = "SELECT_BY_STATUS_NAME",
            query = "from com.bsuir.model.entity.OrderedGoods g where g.order.orderStatus.nameStatus = :nameStatus order by g.order"),
    @NamedQuery(name = "DELETE_BY_ORDER",
            query = "delete from com.bsuir.model.entity.OrderedGoods g where g.order.ordersId = :idorder"),
    @NamedQuery(name = "SELECT_BY_ORDER",
            query = "from com.bsuir.model.entity.OrderedGoods g where g.order.ordersId = :idorder")
    
})
public class OrderedGoods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordered_good_id")
    private Long orderedGoodId;

    @ManyToOne
    @JoinColumn(name = "goods_id",nullable = false)
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Orders order;

    @Column(name = "amount",nullable = false)
    private int amount;
    
    @Column(name = "price",nullable = false)
    private long price;

    public OrderedGoods() {
    }

    public OrderedGoods(Goods goods, Orders order, int amount, long price) {
        this.goods = goods;
        this.order = order;
        this.amount = amount;
        this.price = price;
    }   

    public Long getOrderedGoodId() {
        return orderedGoodId;
    }

    public void setOrderedGoodId(Long orderedGoodId) {
        this.orderedGoodId = orderedGoodId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Orders getOrder() {
        return order;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }  
    

    
    public void setOrder(Orders order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.orderedGoodId != null ? this.orderedGoodId.hashCode() : 0);
        hash = 41 * hash + (this.goods != null ? this.goods.hashCode() : 0);
        hash = 41 * hash + (this.order != null ? this.order.hashCode() : 0);
        hash = 41 * hash + this.amount;
        hash = 41 * hash + (int) (this.price ^ (this.price >>> 32));
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
        final OrderedGoods other = (OrderedGoods) obj;
        if (this.orderedGoodId != other.orderedGoodId && (this.orderedGoodId == null || !this.orderedGoodId.equals(other.orderedGoodId))) {
            return false;
        }
        if (this.goods != other.goods && (this.goods == null || !this.goods.equals(other.goods))) {
            return false;
        }
        if (this.order != other.order && (this.order == null || !this.order.equals(other.order))) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "OrderedGoods{" + "orderedGoodId=" + orderedGoodId + ", goods=" + goods + ", order=" + order + ", amount=" + amount + ", price=" + price + '}';
    }

    
}
