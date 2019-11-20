/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.CompetenceBis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 33785
 */
@Local
public interface CompetenceBisFacadeLocal {

    CompetenceBis create(CompetenceBis competenceBis);

    void edit(CompetenceBis competenceBis);

    void remove(CompetenceBis competenceBis);

    CompetenceBis find(Object id);

    List<CompetenceBis> findAll();

    List<CompetenceBis> findRange(int[] range);

    int count();
    
}
