/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.EquipementBis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 33785
 */
@Local
public interface EquipementBisServiceLocal {
    
    public List<EquipementBis> listerEquipements();
    
}
