/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "SELECT_BY_PAYMENT",
            query = "from model.entity.PaymentMethod d where d.namePm = :namePm")    
})
public class PaymentMethod implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pm_id")
    private Long pmId;

    @Column(name = "name_pm")
    private String namePm;


    public PaymentMethod() {
    }

    public PaymentMethod(String namePm) {
        this.namePm = namePm;
    }

    public Long getPmId() {
        return pmId;
    }

    public void setPmId(Long pmId) {
        this.pmId = pmId;
    }

    public String getNamePm() {
        return namePm;
    }

    public void setNamePm(String namePm) {
        this.namePm = namePm;
    }

 
    @Override
    public String toString() {
        return "PaymentMethod{" + "pmId=" + pmId + ", namePm=" + namePm + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.pmId);
        hash = 67 * hash + Objects.hashCode(this.namePm);
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
        final PaymentMethod other = (PaymentMethod) obj;
        if (!Objects.equals(this.pmId, other.pmId)) {
            return false;
        }
        if (!Objects.equals(this.namePm, other.namePm)) {
            return false;
        }
        return true;
    }
    
    
}
