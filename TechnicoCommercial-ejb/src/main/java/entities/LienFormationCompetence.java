/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 33785
 */
@Entity
@Table(name = "lien_Formation_Competence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LienFormationCompetence.findAll", query = "SELECT l FROM LienFormationCompetence l")
    , @NamedQuery(name = "LienFormationCompetence.findByIdFormation", query = "SELECT l FROM LienFormationCompetence l WHERE l.lienFormationCompetencePK.idFormation = :idFormation")
    , @NamedQuery(name = "LienFormationCompetence.findByIdCompetence", query = "SELECT l FROM LienFormationCompetence l WHERE l.lienFormationCompetencePK.idCompetence = :idCompetence")})
public class LienFormationCompetence implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LienFormationCompetencePK lienFormationCompetencePK;

    public LienFormationCompetence() {
    }

    public LienFormationCompetence(LienFormationCompetencePK lienFormationCompetencePK) {
        this.lienFormationCompetencePK = lienFormationCompetencePK;
    }

    public LienFormationCompetence(int idFormation, int idCompetence) {
        this.lienFormationCompetencePK = new LienFormationCompetencePK(idFormation, idCompetence);
    }

    public LienFormationCompetencePK getLienFormationCompetencePK() {
        return lienFormationCompetencePK;
    }

    public void setLienFormationCompetencePK(LienFormationCompetencePK lienFormationCompetencePK) {
        this.lienFormationCompetencePK = lienFormationCompetencePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lienFormationCompetencePK != null ? lienFormationCompetencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LienFormationCompetence)) {
            return false;
        }
        LienFormationCompetence other = (LienFormationCompetence) object;
        if ((this.lienFormationCompetencePK == null && other.lienFormationCompetencePK != null) || (this.lienFormationCompetencePK != null && !this.lienFormationCompetencePK.equals(other.lienFormationCompetencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LienFormationCompetence[ lienFormationCompetencePK=" + lienFormationCompetencePK + " ]";
    }
    
}
