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
import javax.persistence.Table;

/**
 *
 * @author Katya Omelyashchik
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id",nullable = false)
    private Long clientId;
    
    @Column(name = "surname_client",nullable = false)
    private String surnameClient;
    
    @Column(name = "name_client",nullable = false)
    private String nameClient;
    
    @Column(name = "email_client")
    private String emailClient;
    
    @Column(name = "phone_client",nullable = false)
    private String phoneClient;
    
    @Column(name = "address_client")
    private String addressClient;

    
    public Client() {
    }

    public Client(String surnameClient, String nameClient, String emailClient, String phoneClient, String adressClient) {
        this.surnameClient = surnameClient;
        this.nameClient = nameClient;
        this.emailClient = emailClient;
        this.phoneClient = phoneClient;
        this.addressClient = adressClient;
    }

    
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }


    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", surnameClient=" + surnameClient + ", nameClient=" + nameClient + ", emailClient=" + emailClient + ", phoneClient=" + phoneClient + ", adressClient=" + addressClient + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.clientId);
        hash = 37 * hash + Objects.hashCode(this.surnameClient);
        hash = 37 * hash + Objects.hashCode(this.nameClient);
        hash = 37 * hash + Objects.hashCode(this.emailClient);
        hash = 37 * hash + Objects.hashCode(this.phoneClient);
        hash = 37 * hash + Objects.hashCode(this.addressClient);
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.surnameClient, other.surnameClient)) {
            return false;
        }
        if (!Objects.equals(this.nameClient, other.nameClient)) {
            return false;
        }
        if (!Objects.equals(this.emailClient, other.emailClient)) {
            return false;
        }
        if (!Objects.equals(this.phoneClient, other.phoneClient)) {
            return false;
        }
        if (!Objects.equals(this.addressClient, other.addressClient)) {
            return false;
        }
        return true;
    }
    
    
    
}
