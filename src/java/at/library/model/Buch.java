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
@Table(name = "buch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buch.findAll", query = "SELECT b FROM Buch b"),
    @NamedQuery(name = "Buch.findByMediumId", query = "SELECT b FROM Buch b WHERE b.mediumId = :mediumId"),
    @NamedQuery(name = "Buch.findByIsbn", query = "SELECT b FROM Buch b WHERE b.isbn = :isbn")})
public class Buch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDIUM_ID")
    private Integer mediumId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ISBN")
    private String isbn;
    @JoinColumn(name = "MEDIUM_ID", referencedColumnName = "MEDIUM_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medium medium;

    public Buch() {
    }

    public Buch(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public Buch(Integer mediumId, String isbn) {
        this.mediumId = mediumId;
        this.isbn = isbn;
    }

    public Integer getMediumId() {
        return mediumId;
    }

    public void setMediumId(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
        if (!(object instanceof Buch)) {
            return false;
        }
        Buch other = (Buch) object;
        if ((this.mediumId == null && other.mediumId != null) || (this.mediumId != null && !this.mediumId.equals(other.mediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Buch[ mediumId=" + mediumId + " ]";
    }
    
}
