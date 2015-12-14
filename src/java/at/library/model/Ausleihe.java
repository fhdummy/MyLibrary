/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "ausleihe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ausleihe.findAll", query = "SELECT a FROM Ausleihe a"),
    @NamedQuery(name = "Ausleihe.findByAusleiheId", query = "SELECT a FROM Ausleihe a WHERE a.ausleiheId = :ausleiheId"),
    @NamedQuery(name = "Ausleihe.findByStart", query = "SELECT a FROM Ausleihe a WHERE a.start = :start"),
    @NamedQuery(name = "Ausleihe.findBySollende", query = "SELECT a FROM Ausleihe a WHERE a.sollende = :sollende"),
    @NamedQuery(name = "Ausleihe.findByIstende", query = "SELECT a FROM Ausleihe a WHERE a.istende = :istende")})
public class Ausleihe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AUSLEIHE_ID")
    private Integer ausleiheId;
    @Column(name = "START")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Column(name = "SOLLENDE")
    @Temporal(TemporalType.DATE)
    private Date sollende;
    @Column(name = "ISTENDE")
    @Temporal(TemporalType.DATE)
    private Date istende;
    @JoinColumn(name = "EXEMPLAR_ID", referencedColumnName = "EXEMPLAR_ID")
    @ManyToOne(optional = false)
    private Exemplar exemplarId;
    @JoinColumn(name = "KUNDE_ID", referencedColumnName = "KUNDE_ID")
    @ManyToOne
    private Kunde kundeId;

    public Ausleihe() {
    }

    public Ausleihe(Integer ausleiheId) {
        this.ausleiheId = ausleiheId;
    }

    public Integer getAusleiheId() {
        return ausleiheId;
    }

    public void setAusleiheId(Integer ausleiheId) {
        this.ausleiheId = ausleiheId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getSollende() {
        return sollende;
    }

    public void setSollende(Date sollende) {
        this.sollende = sollende;
    }

    public Date getIstende() {
        return istende;
    }

    public void setIstende(Date istende) {
        this.istende = istende;
    }

    public Exemplar getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(Exemplar exemplarId) {
        this.exemplarId = exemplarId;
    }

    public Kunde getKundeId() {
        return kundeId;
    }

    public void setKundeId(Kunde kundeId) {
        this.kundeId = kundeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ausleiheId != null ? ausleiheId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ausleihe)) {
            return false;
        }
        Ausleihe other = (Ausleihe) object;
        if ((this.ausleiheId == null && other.ausleiheId != null) || (this.ausleiheId != null && !this.ausleiheId.equals(other.ausleiheId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Ausleihe[ ausleiheId=" + ausleiheId + " ]";
    }
    
}
