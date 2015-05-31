/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.dao;

import java.util.List;

/**
 *
 * @author kate
 * @param <T>
 */
public interface Dao <T> {
   
    void create(T newInstance);
    List <T> read();   
    T readById(long id); 
    void update(T transientObject);
    void delete(T persistentObject);
}