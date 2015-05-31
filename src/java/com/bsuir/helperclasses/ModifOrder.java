/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.helperclasses;

import com.bsuir.model.entity.Goods;
import com.bsuir.model.entity.OrderedGoods;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Katya Omelyashchik
 */
public class ModifOrder {

    public List<OrderHelp> getModifOrderList(List<OrderedGoods> orderedGoodsList) {
        int flag = 1;
        int amount[] = null;
        int amountClone[];
        long price[] = null;
        long priceClone[];
        long summa = 0;
        List<OrderHelp> orderHelpList = new ArrayList();
        List<Goods> goodsList = new ArrayList();
        OrderHelp orderHelp = null;
        Long orderId = new Long(-1);

        for (OrderedGoods ogl : orderedGoodsList) {
            if (orderId == ogl.getOrder().getOrdersId()) {
                goodsList.add(ogl.getGoods());
                orderHelp.setOrder(ogl.getOrder());
                amountClone = amount.clone();
                amount = new int[flag];
                System.arraycopy(amountClone, 0, amount, 0, amountClone.length);
                amount[flag - 1] = ogl.getAmount();
                orderHelp.setAmount(amount);
                
                priceClone = price.clone();
                price = new long[flag];
                System.arraycopy(priceClone, 0, price, 0, priceClone.length);
                price[flag - 1] = ogl.getPrice();
                orderHelp.setPrice(price);
                
                orderHelp.setGoods(goodsList);
                summa += ogl.getPrice() * ogl.getAmount();
                orderHelp.setSumma(summa);
            } else {
                flag = 1;
                summa = 0;
                amount = new int[1];
                price = new long[1];
                if (orderHelp != null) {
                    orderHelpList.add(orderHelp);
                }
                summa += ogl.getPrice() * ogl.getAmount();
                summa += ogl.getOrder().getDeliveryMethod().getPriceDm();

                orderHelp = new OrderHelp();
                goodsList = new ArrayList();
                goodsList.add(ogl.getGoods());
                orderHelp.setOrder(ogl.getOrder());
                amount[0] = ogl.getAmount();
                orderHelp.setAmount(amount);
                price[0] = ogl.getPrice();
                orderHelp.setPrice(price);
                orderHelp.setGoods(goodsList);
                orderHelp.setSumma(summa);
            }
            orderId = ogl.getOrder().getOrdersId();
            flag++;
        }
        orderHelpList.add(orderHelp);
        return orderHelpList;

    }
}
