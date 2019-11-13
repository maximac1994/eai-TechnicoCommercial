/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 33785
 */
@Embeddable
public class LienFormationCompetencePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idFormation")
    private int idFormation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompetence")
    private int idCompetence;

    public LienFormationCompetencePK() {
    }

    public LienFormationCompetencePK(int idFormation, int idCompetence) {
        this.idFormation = idFormation;
        this.idCompetence = idCompetence;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFormation;
        hash += (int) idCompetence;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LienFormationCompetencePK)) {
            return false;
        }
        LienFormationCompetencePK other = (LienFormationCompetencePK) object;
        if (this.idFormation != other.idFormation) {
            return false;
        }
        if (this.idCompetence != other.idCompetence) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LienFormationCompetencePK[ idFormation=" + idFormation + ", idCompetence=" + idCompetence + " ]";
    }
    
}
