/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "exemplar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exemplar.findAll", query = "SELECT e FROM Exemplar e"),
    @NamedQuery(name = "Exemplar.findByExemplarId", query = "SELECT e FROM Exemplar e WHERE e.exemplarId = :exemplarId"),
    @NamedQuery(name = "Exemplar.findByInventarNr", query = "SELECT e FROM Exemplar e WHERE e.inventarNr = :inventarNr")})
public class Exemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EXEMPLAR_ID")
    private Integer exemplarId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "INVENTAR_NR")
    private String inventarNr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exemplarId")
    private Collection<Ausleihe> ausleiheCollection;
    @JoinColumn(name = "MEDIUM_ID", referencedColumnName = "MEDIUM_ID")
    @ManyToOne(optional = false)
    private Medium mediumId;

    public Exemplar() {
    }

    public Exemplar(Integer exemplarId) {
        this.exemplarId = exemplarId;
    }

    public Exemplar(Integer exemplarId, String inventarNr) {
        this.exemplarId = exemplarId;
        this.inventarNr = inventarNr;
    }

    public Integer getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(Integer exemplarId) {
        this.exemplarId = exemplarId;
    }

    public String getInventarNr() {
        return inventarNr;
    }

    public void setInventarNr(String inventarNr) {
        this.inventarNr = inventarNr;
    }

    @XmlTransient
    public Collection<Ausleihe> getAusleiheCollection() {
        return ausleiheCollection;
    }

    public void setAusleiheCollection(Collection<Ausleihe> ausleiheCollection) {
        this.ausleiheCollection = ausleiheCollection;
    }

    public Medium getMediumId() {
        return mediumId;
    }

    public void setMediumId(Medium mediumId) {
        this.mediumId = mediumId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exemplarId != null ? exemplarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exemplar)) {
            return false;
        }
        Exemplar other = (Exemplar) object;
        if ((this.exemplarId == null && other.exemplarId != null) || (this.exemplarId != null && !this.exemplarId.equals(other.exemplarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Exemplar[ exemplarId=" + exemplarId + " ]";
    }
    
}
