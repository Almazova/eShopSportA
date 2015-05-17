/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.entity.OrderedGoods;
import model.dao.*;
import model.entity.*;

/**
 *
 * @author asus
 * @param <T>
 */
public class Factory<T> {

    private static DaoImpl categoryDao = null;
    private static DaoImpl clubDao = null;
    private static DaoImpl goodsDao = null;
    private static DaoImpl clientDao = null;
    private static DaoImpl deliveryMethodDao = null;
    private static DaoImpl orderDao = null;
    private static DaoImpl orderStatusDao = null;
    private static DaoImpl paymentMethodDao = null;
    private static DaoImpl orderedGoodsDao = null;

    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public DaoImpl getDAO(T t) {
        if (t.getClass() == Goods.class) {
            if (goodsDao == null) {
                goodsDao = new GoodsDaoImpl();
            }
            return goodsDao;
        } else if (t.getClass() == Category.class) {
            if (categoryDao == null) {
                categoryDao = new CategoryDaoImpl();
            }
            return categoryDao;
        } else if (t.getClass() == Club.class) {
            if (clubDao == null) {
                clubDao = new ClubDaoImpl();
            }
            return clubDao;
        } else if (t.getClass() == Client.class) {
            if (clientDao == null) {
                clientDao = new ClientDaoImpl();
            }
            return clientDao;
        } else if (t.getClass() == DeliveryMethod.class) {
            if (deliveryMethodDao == null) {
                deliveryMethodDao = new DeliveryMethodDaoImpl();
            }
            return deliveryMethodDao;
        } else if (t.getClass() == Orders.class) {
            if (orderDao == null) {
                orderDao = new OrderDaoImpl();
            }
            return orderDao;
        } else if (t.getClass() == OrderStatus.class) {
            if (orderStatusDao == null) {
                orderStatusDao = new OrderStatusDaoImpl();
            }
            return orderStatusDao;
        } else if (t.getClass() == PaymentMethod.class) {
            if (paymentMethodDao == null) {
                paymentMethodDao = new PaymentMethodDaoImpl();
            }
            return paymentMethodDao;
        } else if (t.getClass() ==  OrderedGoods.class) {
            if (orderedGoodsDao == null) {
                orderedGoodsDao = new OrderedGoodsDaoImpl();
            }
            return orderedGoodsDao;
        }

        return null;

    }
}
