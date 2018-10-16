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
public interface KeeperDao {
    public void save(KeeperEntity k);
    public void update(KeeperEntity k);
    public void delete(KeeperEntity a);
    public void addAnimal(KeeperEntity k, AnimalEntity a);
    public KeeperEntity find(String nom);
    public List<KeeperEntity> findAll();
}
