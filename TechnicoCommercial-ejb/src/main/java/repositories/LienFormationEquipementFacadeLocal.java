/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.LienFormationEquipement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 33785
 */
@Local
public interface LienFormationEquipementFacadeLocal {

    LienFormationEquipement create(LienFormationEquipement lienFormationEquipement);

    void edit(LienFormationEquipement lienFormationEquipement);

    void remove(LienFormationEquipement lienFormationEquipement);

    LienFormationEquipement find(Object id);

    List<LienFormationEquipement> findAll();

    List<LienFormationEquipement> findRange(int[] range);

    int count();
    
}
