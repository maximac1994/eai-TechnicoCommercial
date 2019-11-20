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
public class LienFormationEquipementPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idFormation")
    private int idFormation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEquipement")
    private int idEquipement;

    public LienFormationEquipementPK() {
    }

    public LienFormationEquipementPK(int idFormation, int idEquipement) {
        this.idFormation = idFormation;
        this.idEquipement = idEquipement;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFormation;
        hash += (int) idEquipement;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LienFormationEquipementPK)) {
            return false;
        }
        LienFormationEquipementPK other = (LienFormationEquipementPK) object;
        if (this.idFormation != other.idFormation) {
            return false;
        }
        if (this.idEquipement != other.idEquipement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LienFormationEquipementPK[ idFormation=" + idFormation + ", idEquipement=" + idEquipement + " ]";
    }
    
}
