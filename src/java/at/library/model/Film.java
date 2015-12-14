/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
    @NamedQuery(name = "Film.findByMediumId", query = "SELECT f FROM Film f WHERE f.mediumId = :mediumId"),
    @NamedQuery(name = "Film.findByRegisseur", query = "SELECT f FROM Film f WHERE f.regisseur = :regisseur")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDIUM_ID")
    private Integer mediumId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "REGISSEUR")
    private String regisseur;
    @JoinColumn(name = "MEDIUM_ID", referencedColumnName = "MEDIUM_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medium medium;

    public Film() {
    }

    public Film(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public Film(Integer mediumId, String regisseur) {
        this.mediumId = mediumId;
        this.regisseur = regisseur;
    }

    public Integer getMediumId() {
        return mediumId;
    }

    public void setMediumId(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediumId != null ? mediumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.mediumId == null && other.mediumId != null) || (this.mediumId != null && !this.mediumId.equals(other.mediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Film[ mediumId=" + mediumId + " ]";
    }
    
}
