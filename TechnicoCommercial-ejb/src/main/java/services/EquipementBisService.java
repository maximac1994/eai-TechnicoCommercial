/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import business.GestionEquipementsLocal;
import entities.EquipementBis;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 33785
 */
@Stateless
public class EquipementBisService implements EquipementBisServiceLocal {

    @EJB
    GestionEquipementsLocal gel;
    
    @Override
    public List<EquipementBis> listerEquipements() {
        return gel.listerEquipements();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
