/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "order_status")
public class OrderStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "name_status")
    private String nameStatus;

    public OrderStatus() {
    }

    public OrderStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @Override
    public String toString() {
        return "OrderStatus{" + "statusId=" + statusId + ", nameStatus=" + nameStatus + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.statusId);
        hash = 97 * hash + Objects.hashCode(this.nameStatus);
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
        final OrderStatus other = (OrderStatus) obj;
        if (!Objects.equals(this.statusId, other.statusId)) {
            return false;
        }
        if (!Objects.equals(this.nameStatus, other.nameStatus)) {
            return false;
        }
        return true;
    }
    
    
}
