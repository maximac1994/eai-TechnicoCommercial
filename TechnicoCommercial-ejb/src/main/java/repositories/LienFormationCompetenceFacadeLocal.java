/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.LienFormationCompetence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 33785
 */
@Local
public interface LienFormationCompetenceFacadeLocal {

    LienFormationCompetence create(LienFormationCompetence lienFormationCompetence);

    void edit(LienFormationCompetence lienFormationCompetence);

    void remove(LienFormationCompetence lienFormationCompetence);

    LienFormationCompetence find(Object id);

    List<LienFormationCompetence> findAll();

    List<LienFormationCompetence> findRange(int[] range);

    int count();
    
    public List<Integer> findByIdFormation(int idFormation);
    
}
