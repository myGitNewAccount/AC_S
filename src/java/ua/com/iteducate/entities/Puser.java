/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Anton
 */
@Entity
@Table(name = "puser")
@NamedQueries({
    @NamedQuery(name = "Puser.findAll", query = "SELECT p FROM Puser p")})
public class Puser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "puser_id")
    private Integer puserId;
    @Column(name = "puser_name")
    private String puserName;
    @Column(name = "puser_surname")
    private String puserSurname;
    @Column(name = "puser_patronymic")
    private String puserPatronymic;
    @Column(name = "puser_password")
    private String puserPassword;
    @Column(name = "membershipID")
    private String membershipID;
    @Column(name = "ec")
    private String ec;
    @JoinColumn(name = "puser_purse_id", referencedColumnName = "purse_id")
    @ManyToOne
    private Purse purse;

    public Puser() {
    }

    public Puser(Integer puserId) {
        this.puserId = puserId;
    }

    public Integer getPuserId() {
        return puserId;
    }
    
    public String getEC() {
        return ec;
    }
    
    public void setEC(String ec) {
        this.ec = ec;
    }

    public void setPuserId(Integer puserId) {
        this.puserId = puserId;
    }

    public String getPuserName() {
        return puserName;
    }

    public void setPuserName(String puserName) {
        this.puserName = puserName;
    }

    public String getPuserSurname() {
        return puserSurname;
    }
    
    public String getMembershipID() {
        return membershipID;
    }

    public void setPuserSurname(String puserSurname) {
        this.puserSurname = puserSurname;
    }

    public String getPuserPatronymic() {
        return puserPatronymic;
    }

    public void setPuserPatronymic(String puserPatronymic) {
        this.puserPatronymic = puserPatronymic;
    }
    
    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }

    public String getPuserPassword() {
        return puserPassword;
    }

    public void setPuserPassword(String puserPassword) {
        this.puserPassword = puserPassword;
    }

    public Purse getPurse() {
        return purse;
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puserId != null ? puserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puser)) {
            return false;
        }
        Puser other = (Puser) object;
        if ((this.puserId == null && other.puserId != null) || (this.puserId != null && !this.puserId.equals(other.puserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.iteducate.entities.Puser[ puserId=" + puserId + " ]";
    }
    
}
