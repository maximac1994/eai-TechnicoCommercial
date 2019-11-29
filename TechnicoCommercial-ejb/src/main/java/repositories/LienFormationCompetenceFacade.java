/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.LienFormationCompetence;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<Integer> findByIdFormation(int idFormation) {
        List<LienFormationCompetence> liste = (em.createNamedQuery("LienFormationCompetence.findByIdFormation")).setParameter("idFormation", idFormation).getResultList();
        List<Integer> listeIdCompetences = new ArrayList<Integer>();
        for (LienFormationCompetence c : liste) {
            listeIdCompetences.add(c.getLienFormationCompetencePK().getIdCompetence());
        }
        return listeIdCompetences;
    }

}
