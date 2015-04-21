/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.Goods;



/**
 *
 * @author asus
 */
public class GoodsDaoImpl extends DaoImpl{

    public GoodsDaoImpl() {
        super(Goods.class);
    }
    
  
    @Override
     public void deleteById(long id){
        delete(readById(id));
    }
    
}
