/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.EquipementBis;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.EquipementBisFacadeLocal;

/**
 *
 * @author 33785
 */
@Stateless
public class GestionEquipements implements GestionEquipementsLocal {

    @EJB
    EquipementBisFacadeLocal ebfl;
    
    @Override
    public List<EquipementBis> listerEquipements() {
        return ebfl.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
