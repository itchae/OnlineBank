/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.dao;

import java.util.List;

/**
 *
 * @author edarles
 */

public interface AnimalDao {
    
    public void save(AnimalEntity a);
    public void update(AnimalEntity a);
    public void delete(AnimalEntity a);
    public void addKeeper(AnimalEntity a, KeeperEntity k);
    public AnimalEntity find(String nom);
    public List<AnimalEntity> findAll();
}
