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
@Table(name = "club")
@NamedQueries({
    @NamedQuery(name = "SELECT_BY_CLUB_NAME",
            query = "from com.bsuir.model.entity.Club c where c.nameClub = :nameClub")
})
public class Club implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "name_club")
    private String nameClub;


    public Club() {
    }

    public Club(String nameClub) {
        this.nameClub = nameClub;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getNameClub() {
        return nameClub;
    }

    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
    }



    @Override
    public String toString() {
        return "Club{" + "clubId=" + clubId + ", nameClub=" + nameClub + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.clubId);
        hash = 53 * hash + Objects.hashCode(this.nameClub);
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
        final Club other = (Club) obj;
        if (!Objects.equals(this.clubId, other.clubId)) {
            return false;
        }
        if (!Objects.equals(this.nameClub, other.nameClub)) {
            return false;
        }
        return true;
    }

}
