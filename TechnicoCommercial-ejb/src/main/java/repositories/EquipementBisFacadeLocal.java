/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.EquipementBis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 33785
 */
@Local
public interface EquipementBisFacadeLocal {

    EquipementBis create(EquipementBis equipementBis);

    void edit(EquipementBis equipementBis);

    void remove(EquipementBis equipementBis);

    EquipementBis find(Object id);

    List<EquipementBis> findAll();

    List<EquipementBis> findRange(int[] range);

    int count();
    
}
