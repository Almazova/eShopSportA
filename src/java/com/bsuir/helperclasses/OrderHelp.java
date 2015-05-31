/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.helperclasses;

import com.bsuir.model.entity.Goods;
import com.bsuir.model.entity.Orders;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Katya Omelyashchik
 */
public class OrderHelp {

    private List<Goods> goods;
    private Orders order;
    private int amount[];
    private long price[];
    private long summa;

    public long getSumma() {
        return summa;
    }

    public void setSumma(long summa) {
        this.summa = summa;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public int[] getAmount() {
        return amount;
    }

    public void setAmount(int[] amount) {
        this.amount = amount;
    }

    public long[] getPrice() {
        return price;
    }

    public void setPrice(long[] price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderHelp{" + "goods=" + goods + ", order=" + order + ", amount=" + amount + ", price=" + price + ", summa=" + summa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.goods != null ? this.goods.hashCode() : 0);
        hash = 29 * hash + (this.order != null ? this.order.hashCode() : 0);
        hash = 29 * hash + Arrays.hashCode(this.amount);
        hash = 29 * hash + Arrays.hashCode(this.price);
        hash = 29 * hash + (int) (this.summa ^ (this.summa >>> 32));
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
        final OrderHelp other = (OrderHelp) obj;
        if (this.goods != other.goods && (this.goods == null || !this.goods.equals(other.goods))) {
            return false;
        }
        if (this.order != other.order && (this.order == null || !this.order.equals(other.order))) {
            return false;
        }
        if (!Arrays.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Arrays.equals(this.price, other.price)) {
            return false;
        }
        if (this.summa != other.summa) {
            return false;
        }
        return true;
    }

    
   
}
