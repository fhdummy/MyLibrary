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
@Table(name = "cd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cd.findAll", query = "SELECT c FROM Cd c"),
    @NamedQuery(name = "Cd.findByMediumId", query = "SELECT c FROM Cd c WHERE c.mediumId = :mediumId"),
    @NamedQuery(name = "Cd.findByAlbum", query = "SELECT c FROM Cd c WHERE c.album = :album")})
public class Cd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDIUM_ID")
    private Integer mediumId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ALBUM")
    private String album;
    @JoinColumn(name = "MEDIUM_ID", referencedColumnName = "MEDIUM_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medium medium;

    public Cd() {
    }

    public Cd(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public Cd(Integer mediumId, String album) {
        this.mediumId = mediumId;
        this.album = album;
    }

    public Integer getMediumId() {
        return mediumId;
    }

    public void setMediumId(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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
        if (!(object instanceof Cd)) {
            return false;
        }
        Cd other = (Cd) object;
        if ((this.mediumId == null && other.mediumId != null) || (this.mediumId != null && !this.mediumId.equals(other.mediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Cd[ mediumId=" + mediumId + " ]";
    }
    
}
