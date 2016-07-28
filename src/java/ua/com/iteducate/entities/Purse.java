/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Anton
 */
@Entity
@Table(name = "purse")
@NamedQueries({
    @NamedQuery(name = "Purse.findAll", query = "SELECT p FROM Purse p")})
public class Purse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purse_id")
    private Integer purseId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purse_money_uan")
    private Double purseMoneyUan;
    @Column(name = "purse_status")
    private Boolean purseStatus;
    @OneToMany(mappedBy = "purse")
    private Collection<Puser> puserCollection;

    public Purse() {
    }

    public Purse(Integer purseId) {
        this.purseId = purseId;
    }

    public Integer getPurseId() {
        return purseId;
    }

    public void setPurseId(Integer purseId) {
        this.purseId = purseId;
    }

    public Double getPurseMoneyUan() {
        return purseMoneyUan;
    }

    public void setPurseMoneyUan(Double purseMoneyUan) {
        this.purseMoneyUan = purseMoneyUan;
    }

    public Boolean getPurseStatus() {
        return purseStatus;
    }

    public void setPurseStatus(Boolean purseStatus) {
        this.purseStatus = purseStatus;
    }

    public Collection<Puser> getPuserCollection() {
        return puserCollection;
    }

    public void setPuserCollection(Collection<Puser> puserCollection) {
        this.puserCollection = puserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purseId != null ? purseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purse)) {
            return false;
        }
        Purse other = (Purse) object;
        if ((this.purseId == null && other.purseId != null) || (this.purseId != null && !this.purseId.equals(other.purseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.iteducate.entities.Purse[ purseId=" + purseId + " ]";
    }
    
}
