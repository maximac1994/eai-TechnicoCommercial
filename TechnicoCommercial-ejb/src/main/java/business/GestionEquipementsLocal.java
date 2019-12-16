/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.EquipementBis;
import java.util.List;
import javax.ejb.Local;

/**
 * gestion des equipements disponibles
 * @author 33785
 */
@Local
public interface GestionEquipementsLocal {
    
    /**
     * lister les equipements
     * @return
     */
    public List<EquipementBis> listerEquipements();
    
}
