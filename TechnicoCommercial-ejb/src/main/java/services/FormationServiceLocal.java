/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Formation;
import exceptions.UnknownFormationException;
import java.util.List;
import javax.ejb.Local;
import resources.FormationResource;

/**
 * Exposition des traitements relatifs aux foamtions en REST
 * @author 33785
 */
@Local
public interface FormationServiceLocal {
    
    /**
     * lister les formations
     * @return
     */
    public List<Formation> listerFormations();
    
    /**
     * creer une formation
     * @param formation
     */
    public void creerFormation(FormationResource formation);
    
    /**
     * supprimer une formation
     * @param idFormation
     * @throws UnknownFormationException
     */
    public void supprimerFormation(int idFormation) throws UnknownFormationException;
    
}
