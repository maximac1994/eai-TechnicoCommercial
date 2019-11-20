/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.EquipementBis;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 33785
 */
@Stateless
public class EquipementBisFacade extends AbstractFacade<EquipementBis> implements EquipementBisFacadeLocal {

    @PersistenceContext(unitName = "ProjetJEE_TechnicoCommercial-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipementBisFacade() {
        super(EquipementBis.class);
    }
    
}
