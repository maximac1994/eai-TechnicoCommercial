/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Formation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 33785
 */
@Local
public interface FormationFacadeLocal {

    Formation create(Formation formation);

    void edit(Formation formation);

    void remove(Formation formation);

    Formation find(Object id);

    List<Formation> findAll();

    List<Formation> findRange(int[] range);

    int count();
    
    List<Formation> findByCode(String codeFormation);
    
}
