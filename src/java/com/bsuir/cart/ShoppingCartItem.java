/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.cart;

import com.bsuir.model.entity.Goods;

/**
 *
 * @author Katya Omelyashchik
 */
public class ShoppingCartItem {

    private final Goods goods;
    private short quantity;

    public ShoppingCartItem(Goods goods) {
        this.goods = goods;
        quantity = 1;
    }

    public Goods getGoods() {
        return goods;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public long getTotal() {
        long amount = 0;
        amount = (this.getQuantity() * goods.getPriceGoods());
        return amount;
    }
}
