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
@Table(name = "bibliothek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliothek.findAll", query = "SELECT b FROM Bibliothek b"),
    @NamedQuery(name = "Bibliothek.findByBibliothekId", query = "SELECT b FROM Bibliothek b WHERE b.bibliothekId = :bibliothekId"),
    @NamedQuery(name = "Bibliothek.findByName", query = "SELECT b FROM Bibliothek b WHERE b.name = :name")})
public class Bibliothek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BIBLIOTHEK_ID")
    private Integer bibliothekId;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bibliothekId")
    private Collection<Medium> mediumCollection;

    public Bibliothek() {
    }

    public Bibliothek(Integer bibliothekId) {
        this.bibliothekId = bibliothekId;
    }

    public Integer getBibliothekId() {
        return bibliothekId;
    }

    public void setBibliothekId(Integer bibliothekId) {
        this.bibliothekId = bibliothekId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (bibliothekId != null ? bibliothekId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliothek)) {
            return false;
        }
        Bibliothek other = (Bibliothek) object;
        if ((this.bibliothekId == null && other.bibliothekId != null) || (this.bibliothekId != null && !this.bibliothekId.equals(other.bibliothekId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Bibliothek[ bibliothekId=" + bibliothekId + " ]";
    }
    
}
