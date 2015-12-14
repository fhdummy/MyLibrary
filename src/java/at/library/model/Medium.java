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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "medium")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medium.findAll", query = "SELECT m FROM Medium m"),
    @NamedQuery(name = "Medium.findByMediumId", query = "SELECT m FROM Medium m WHERE m.mediumId = :mediumId"),
    @NamedQuery(name = "Medium.findByTitel", query = "SELECT m FROM Medium m WHERE m.titel = :titel"),
    @NamedQuery(name = "Medium.findByJahr", query = "SELECT m FROM Medium m WHERE m.jahr = :jahr"),
    @NamedQuery(name = "Medium.findByTyp", query = "SELECT m FROM Medium m WHERE m.typ = :typ")})
public class Medium implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEDIUM_ID")
    private Integer mediumId;
    @Size(max = 30)
    @Column(name = "TITEL")
    private String titel;
    @Column(name = "JAHR")
    private Integer jahr;
    @Size(max = 30)
    @Column(name = "TYP")
    private String typ;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medium")
    private Cd cd;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medium")
    private Buch buch;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediumId")
    private Collection<Exemplar> exemplarCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medium")
    private Film film;
    @JoinColumn(name = "BIBLIOTHEK_ID", referencedColumnName = "BIBLIOTHEK_ID")
    @ManyToOne(optional = false)
    private Bibliothek bibliothekId;
    @JoinColumn(name = "REGAL_ID", referencedColumnName = "REGAL_ID")
    @ManyToOne
    private Regal regalId;

    public Medium() {
    }

    public Medium(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public Integer getMediumId() {
        return mediumId;
    }

    public void setMediumId(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Integer getJahr() {
        return jahr;
    }

    public void setJahr(Integer jahr) {
        this.jahr = jahr;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }

    public Buch getBuch() {
        return buch;
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    @XmlTransient
    public Collection<Exemplar> getExemplarCollection() {
        return exemplarCollection;
    }

    public void setExemplarCollection(Collection<Exemplar> exemplarCollection) {
        this.exemplarCollection = exemplarCollection;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Bibliothek getBibliothekId() {
        return bibliothekId;
    }

    public void setBibliothekId(Bibliothek bibliothekId) {
        this.bibliothekId = bibliothekId;
    }

    public Regal getRegalId() {
        return regalId;
    }

    public void setRegalId(Regal regalId) {
        this.regalId = regalId;
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
        if (!(object instanceof Medium)) {
            return false;
        }
        Medium other = (Medium) object;
        if ((this.mediumId == null && other.mediumId != null) || (this.mediumId != null && !this.mediumId.equals(other.mediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Medium[ mediumId=" + mediumId + " ]";
    }
    
}
