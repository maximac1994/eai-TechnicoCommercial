/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.CompetenceBis;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.CompetenceBisFacadeLocal;

/**
 *
 * @author 33785
 */
@Stateless
public class GestionCompetences implements GestionCompetencesLocal {

    @EJB
    CompetenceBisFacadeLocal cbfl;
    
    @Override
    public List<CompetenceBis> listerCompetences() {
        return cbfl.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
