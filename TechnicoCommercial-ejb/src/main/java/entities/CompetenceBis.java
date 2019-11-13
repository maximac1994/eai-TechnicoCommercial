/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 33785
 */
@Entity
@Table(name = "CompetenceBis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetenceBis.findAll", query = "SELECT c FROM CompetenceBis c")
    , @NamedQuery(name = "CompetenceBis.findByIdCompetence", query = "SELECT c FROM CompetenceBis c WHERE c.idCompetence = :idCompetence")
    , @NamedQuery(name = "CompetenceBis.findByNomCompetence", query = "SELECT c FROM CompetenceBis c WHERE c.nomCompetence = :nomCompetence")})
public class CompetenceBis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompetence")
    private Integer idCompetence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nomCompetence")
    private String nomCompetence;

    public CompetenceBis() {
    }

    public CompetenceBis(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public CompetenceBis(Integer idCompetence, String nomCompetence) {
        this.idCompetence = idCompetence;
        this.nomCompetence = nomCompetence;
    }

    public Integer getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetence != null ? idCompetence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenceBis)) {
            return false;
        }
        CompetenceBis other = (CompetenceBis) object;
        if ((this.idCompetence == null && other.idCompetence != null) || (this.idCompetence != null && !this.idCompetence.equals(other.idCompetence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompetenceBis[ idCompetence=" + idCompetence + " ]";
    }
    
}
