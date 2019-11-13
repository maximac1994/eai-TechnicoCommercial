/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.List;

/**
 *
 * @author 33785
 */
public class FormationResource {

    private String codeFormation;
    private String libelleFormation;
    private int dureeFormation;
    private List<Integer> equipementsNecessaires;
    private List<Integer> competencesNecessaires;
    private int nbMin;
    private int nbMax;
    private String thematiqueFormation;
    private int niveauFormation;

    public String getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getLibelleFormation() {
        return libelleFormation;
    }

    public void setLibelleFormation(String libelleFormation) {
        this.libelleFormation = libelleFormation;
    }

    public int getDureeFormation() {
        return dureeFormation;
    }

    public void setDureeFormation(int dureeFormation) {
        this.dureeFormation = dureeFormation;
    }

    public List<Integer> getEquipementsNecessaires() {
        return equipementsNecessaires;
    }

    public void setEquipementsNecessaires(List<Integer> equipementsNecessaires) {
        this.equipementsNecessaires = equipementsNecessaires;
    }

    public List<Integer> getCompetencesNecessaires() {
        return competencesNecessaires;
    }

    public void setCompetencesNecessaires(List<Integer> competencesNecessaires) {
        this.competencesNecessaires = competencesNecessaires;
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
    public String toString() {
        return "FormationResource{" + "codeFormation=" + codeFormation + ", libelleFormation=" + libelleFormation + ", dureeFormation=" + dureeFormation + ", equipementsNecessaires=" + equipementsNecessaires + ", competencesNecessaires=" + competencesNecessaires + ", nbMin=" + nbMin + ", nbMax=" + nbMax + ", thematiqueFormation=" + thematiqueFormation + ", niveauFormation=" + niveauFormation + '}';
    }

    
    
}
