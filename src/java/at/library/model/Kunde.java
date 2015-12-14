/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "kunde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k"),
    @NamedQuery(name = "Kunde.findByKundeId", query = "SELECT k FROM Kunde k WHERE k.kundeId = :kundeId"),
    @NamedQuery(name = "Kunde.findByGeburtstag", query = "SELECT k FROM Kunde k WHERE k.geburtstag = :geburtstag"),
    @NamedQuery(name = "Kunde.findByStudent", query = "SELECT k FROM Kunde k WHERE k.student = :student"),
    @NamedQuery(name = "Kunde.findByName", query = "SELECT k FROM Kunde k WHERE k.name = :name"),
    @NamedQuery(name = "Kunde.findByIstbetrag", query = "SELECT k FROM Kunde k WHERE k.istbetrag = :istbetrag"),
    @NamedQuery(name = "Kunde.findBySollbetrag", query = "SELECT k FROM Kunde k WHERE k.sollbetrag = :sollbetrag")})
public class Kunde implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KUNDE_ID")
    private Integer kundeId;
    @Column(name = "GEBURTSTAG")
    @Temporal(TemporalType.DATE)
    private Date geburtstag;
    @Column(name = "STUDENT")
    private Short student;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ISTBETRAG")
    private Float istbetrag;
    @Column(name = "SOLLBETRAG")
    private Float sollbetrag;
    @OneToMany(mappedBy = "kundeId")
    private Collection<Ausleihe> ausleiheCollection;

    public Kunde() {
    }

    public Kunde(Integer kundeId) {
        this.kundeId = kundeId;
    }

    public Integer getKundeId() {
        return kundeId;
    }

    public void setKundeId(Integer kundeId) {
        this.kundeId = kundeId;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public Short getStudent() {
        return student;
    }

    public void setStudent(Short student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getIstbetrag() {
        return istbetrag;
    }

    public void setIstbetrag(Float istbetrag) {
        this.istbetrag = istbetrag;
    }

    public Float getSollbetrag() {
        return sollbetrag;
    }

    public void setSollbetrag(Float sollbetrag) {
        this.sollbetrag = sollbetrag;
    }

    @XmlTransient
    public Collection<Ausleihe> getAusleiheCollection() {
        return ausleiheCollection;
    }

    public void setAusleiheCollection(Collection<Ausleihe> ausleiheCollection) {
        this.ausleiheCollection = ausleiheCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kundeId != null ? kundeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kunde)) {
            return false;
        }
        Kunde other = (Kunde) object;
        if ((this.kundeId == null && other.kundeId != null) || (this.kundeId != null && !this.kundeId.equals(other.kundeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Kunde[ kundeId=" + kundeId + " ]";
    }
    
}
