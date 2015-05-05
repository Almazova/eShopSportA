/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import model.entity.Goods;

/**
 *
 * @author asus
 */
public class ShoppingCartItem {

    Goods goods;
    short quantity;

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

    public double getTotal() {
        long amount = 0;
        amount = (this.getQuantity() * goods.getPriceGoods());
        return amount;
    }
}
