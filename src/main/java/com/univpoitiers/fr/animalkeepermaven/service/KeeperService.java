/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.service;

import com.univpoitiers.fr.animalkeepermaven.dao.KeeperEntity;


/**
 *
 * @author edarles
 */
public interface KeeperService {
 
    public boolean add(String nom, String prenom, String age, String adresse);
    public boolean remove(String nom);
    public KeeperEntity find(String nom);
    public void addAnimal(String nomKeeper, String nomAnimal);
    public String printKeepers();
    public String printAnimals(String nomKeeper);
}
