/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsuir.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Katya Omelyashchik
 */
@Entity
@Table(name = "delivery")
@NamedQueries({
    @NamedQuery(name = "SELECT_BY_DELIVERY",
            query = "from com.bsuir.model.entity.DeliveryMethod d where d.nameDm = :nameDm")
})
public class DeliveryMethod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dm_id")
    private Long dmId;

    @Column(name = "name_dm")
    private String nameDm;

    @Column(name = "price_dm")
    private long priceDm;



    public DeliveryMethod() {
    }

    public DeliveryMethod(String nameDm, long priceDm) {
        this.nameDm = nameDm;
        this.priceDm = priceDm;
    }

    public Long getDmId() {
        return dmId;
    }

    public void setDmId(Long dmId) {
        this.dmId = dmId;
    }

    public String getNameDm() {
        return nameDm;
    }

    public void setNameDm(String nameDm) {
        this.nameDm = nameDm;
    }

    public long getPriceDm() {
        return priceDm;
    }

    public void setPriceDm(long priceDm) {
        this.priceDm = priceDm;
    }



    @Override
    public String toString() {
        return "DeliveryMethod{" + "dmId=" + dmId + ", nameDm=" + nameDm + ", priceDm=" + priceDm + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.dmId);
        hash = 13 * hash + Objects.hashCode(this.nameDm);
        hash = 13 * hash + (int) (this.priceDm ^ (this.priceDm >>> 32));
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
        final DeliveryMethod other = (DeliveryMethod) obj;
        if (!Objects.equals(this.dmId, other.dmId)) {
            return false;
        }
        if (!Objects.equals(this.nameDm, other.nameDm)) {
            return false;
        }
        if (this.priceDm != other.priceDm) {
            return false;
        }
        return true;
    }

}
