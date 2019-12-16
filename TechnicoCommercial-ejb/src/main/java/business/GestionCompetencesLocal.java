/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.CompetenceBis;
import java.util.List;
import javax.ejb.Local;

/**
 * gestion des competences disponibles
 * @author 33785
 */
@Local
public interface GestionCompetencesLocal {
    
    /**
     * lister les competences
     * @return
     */
    public List<CompetenceBis> listerCompetences();
    
}
