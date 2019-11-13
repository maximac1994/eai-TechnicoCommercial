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
@Table(name = "lien_Formation_Equipement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LienFormationEquipement.findAll", query = "SELECT l FROM LienFormationEquipement l")
    , @NamedQuery(name = "LienFormationEquipement.findByIdFormation", query = "SELECT l FROM LienFormationEquipement l WHERE l.lienFormationEquipementPK.idFormation = :idFormation")
    , @NamedQuery(name = "LienFormationEquipement.findByIdEquipement", query = "SELECT l FROM LienFormationEquipement l WHERE l.lienFormationEquipementPK.idEquipement = :idEquipement")})
public class LienFormationEquipement implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LienFormationEquipementPK lienFormationEquipementPK;

    public LienFormationEquipement() {
    }

    public LienFormationEquipement(LienFormationEquipementPK lienFormationEquipementPK) {
        this.lienFormationEquipementPK = lienFormationEquipementPK;
    }

    public LienFormationEquipement(int idFormation, int idEquipement) {
        this.lienFormationEquipementPK = new LienFormationEquipementPK(idFormation, idEquipement);
    }

    public LienFormationEquipementPK getLienFormationEquipementPK() {
        return lienFormationEquipementPK;
    }

    public void setLienFormationEquipementPK(LienFormationEquipementPK lienFormationEquipementPK) {
        this.lienFormationEquipementPK = lienFormationEquipementPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lienFormationEquipementPK != null ? lienFormationEquipementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LienFormationEquipement)) {
            return false;
        }
        LienFormationEquipement other = (LienFormationEquipement) object;
        if ((this.lienFormationEquipementPK == null && other.lienFormationEquipementPK != null) || (this.lienFormationEquipementPK != null && !this.lienFormationEquipementPK.equals(other.lienFormationEquipementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LienFormationEquipement[ lienFormationEquipementPK=" + lienFormationEquipementPK + " ]";
    }
    
}
