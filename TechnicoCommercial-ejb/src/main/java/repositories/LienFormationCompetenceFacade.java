/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.LienFormationCompetence;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 33785
 */
@Stateless
public class LienFormationCompetenceFacade extends AbstractFacade<LienFormationCompetence> implements LienFormationCompetenceFacadeLocal {

    @PersistenceContext(unitName = "ProjetJEE_TechnicoCommercial-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LienFormationCompetenceFacade() {
        super(LienFormationCompetence.class);
    }
    
}
