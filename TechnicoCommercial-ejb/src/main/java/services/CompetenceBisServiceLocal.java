/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CompetenceBis;
import java.util.List;
import javax.ejb.Local;

/**
 * exposition des traitements relativs aux competences en REST
 * @author 33785
 */
@Local
public interface CompetenceBisServiceLocal {
    
    /**
     * lister les competences
     * @return
     */
    public List<CompetenceBis> listerCompetences();
    
}
