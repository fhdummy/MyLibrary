/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "regal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regal.findAll", query = "SELECT r FROM Regal r"),
    @NamedQuery(name = "Regal.findByRegalId", query = "SELECT r FROM Regal r WHERE r.regalId = :regalId"),
    @NamedQuery(name = "Regal.findByReihe", query = "SELECT r FROM Regal r WHERE r.reihe = :reihe"),
    @NamedQuery(name = "Regal.findByPlatz", query = "SELECT r FROM Regal r WHERE r.platz = :platz"),
    @NamedQuery(name = "Regal.findByMenge", query = "SELECT r FROM Regal r WHERE r.menge = :menge")})
public class Regal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REGAL_ID")
    private Integer regalId;
    @Size(max = 10)
    @Column(name = "REIHE")
    private String reihe;
    @Size(max = 10)
    @Column(name = "PLATZ")
    private String platz;
    @Column(name = "MENGE")
    private Integer menge;
    @OneToMany(mappedBy = "regalId")
    private Collection<Medium> mediumCollection;

    public Regal() {
    }

    public Regal(Integer regalId) {
        this.regalId = regalId;
    }

    public Integer getRegalId() {
        return regalId;
    }

    public void setRegalId(Integer regalId) {
        this.regalId = regalId;
    }

    public String getReihe() {
        return reihe;
    }

    public void setReihe(String reihe) {
        this.reihe = reihe;
    }

    public String getPlatz() {
        return platz;
    }

    public void setPlatz(String platz) {
        this.platz = platz;
    }

    public Integer getMenge() {
        return menge;
    }

    public void setMenge(Integer menge) {
        this.menge = menge;
    }

    @XmlTransient
    public Collection<Medium> getMediumCollection() {
        return mediumCollection;
    }

    public void setMediumCollection(Collection<Medium> mediumCollection) {
        this.mediumCollection = mediumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regalId != null ? regalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regal)) {
            return false;
        }
        Regal other = (Regal) object;
        if ((this.regalId == null && other.regalId != null) || (this.regalId != null && !this.regalId.equals(other.regalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Regal[ regalId=" + regalId + " ]";
    }
    
}
