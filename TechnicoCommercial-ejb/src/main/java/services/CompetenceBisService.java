/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import business.GestionCompetencesLocal;
import entities.CompetenceBis;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 33785
 */
@Stateless
public class CompetenceBisService implements CompetenceBisServiceLocal {

    @EJB
    GestionCompetencesLocal gcl;

    @Override
    public List<CompetenceBis> listerCompetences() {
        return gcl.listerCompetences();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
