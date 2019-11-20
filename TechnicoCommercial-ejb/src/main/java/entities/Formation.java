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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f")
    , @NamedQuery(name = "Formation.findByIdFormation", query = "SELECT f FROM Formation f WHERE f.idFormation = :idFormation")
    , @NamedQuery(name = "Formation.findByCodeFormation", query = "SELECT f FROM Formation f WHERE f.codeFormation = :codeFormation")
    , @NamedQuery(name = "Formation.findByDureeFormation", query = "SELECT f FROM Formation f WHERE f.dureeFormation = :dureeFormation")
    , @NamedQuery(name = "Formation.findByLibelleFormation", query = "SELECT f FROM Formation f WHERE f.libelleFormation = :libelleFormation")
    , @NamedQuery(name = "Formation.findByNbMin", query = "SELECT f FROM Formation f WHERE f.nbMin = :nbMin")
    , @NamedQuery(name = "Formation.findByNbMax", query = "SELECT f FROM Formation f WHERE f.nbMax = :nbMax")
    , @NamedQuery(name = "Formation.findByThematiqueFormation", query = "SELECT f FROM Formation f WHERE f.thematiqueFormation = :thematiqueFormation")
    , @NamedQuery(name = "Formation.findByNiveauFormation", query = "SELECT f FROM Formation f WHERE f.niveauFormation = :niveauFormation")})
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormation")
    private Integer idFormation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codeFormation")
    private String codeFormation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dureeFormation")
    private int dureeFormation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "libelleFormation")
    private String libelleFormation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbMin")
    private int nbMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbMax")
    private int nbMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "thematiqueFormation")
    private String thematiqueFormation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "niveauFormation")
    private int niveauFormation;

    public Formation() {
    }

    public Formation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    public Formation(Integer idFormation, String codeFormation, int dureeFormation, String libelleFormation, int nbMin, int nbMax, String thematiqueFormation, int niveauFormation) {
        this.idFormation = idFormation;
        this.codeFormation = codeFormation;
        this.dureeFormation = dureeFormation;
        this.libelleFormation = libelleFormation;
        this.nbMin = nbMin;
        this.nbMax = nbMax;
        this.thematiqueFormation = thematiqueFormation;
        this.niveauFormation = niveauFormation;
    }

    public Integer getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public int getDureeFormation() {
        return dureeFormation;
    }

    public void setDureeFormation(int dureeFormation) {
        this.dureeFormation = dureeFormation;
    }

    public String getLibelleFormation() {
        return libelleFormation;
    }

    public void setLibelleFormation(String libelleFormation) {
        this.libelleFormation = libelleFormation;
    }

    public int getNbMin() {
        return nbMin;
    }

    public void setNbMin(int nbMin) {
        this.nbMin = nbMin;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public String getThematiqueFormation() {
        return thematiqueFormation;
    }

    public void setThematiqueFormation(String thematiqueFormation) {
        this.thematiqueFormation = thematiqueFormation;
    }

    public int getNiveauFormation() {
        return niveauFormation;
    }

    public void setNiveauFormation(int niveauFormation) {
        this.niveauFormation = niveauFormation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormation != null ? idFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.idFormation == null && other.idFormation != null) || (this.idFormation != null && !this.idFormation.equals(other.idFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Formation[ idFormation=" + idFormation + " ]";
    }
    
}
