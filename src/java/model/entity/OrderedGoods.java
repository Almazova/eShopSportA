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
@Table(name = "ordered_good")
public class OrderedGoods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordered_good_id")
    private Long orderedGoodId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "amount")
    private int amount;

    public OrderedGoods() {
    }

    public OrderedGoods(Goods goods, Order order, int amount) {
        this.goods = goods;
        this.order = order;
        this.amount = amount;
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

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "OrderedGoods{" + "orderedGoodId=" + orderedGoodId + ", goods=" + goods + ", order=" + order + ", amount=" + amount + '}';
    }

    
    public void setOrder(Order order) {
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
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.orderedGoodId);
        hash = 73 * hash + Objects.hashCode(this.goods);
        hash = 73 * hash + Objects.hashCode(this.order);
        hash = 73 * hash + this.amount;
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
        if (!Objects.equals(this.orderedGoodId, other.orderedGoodId)) {
            return false;
        }
        if (!Objects.equals(this.goods, other.goods)) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        return true;
    }
    
    
}
