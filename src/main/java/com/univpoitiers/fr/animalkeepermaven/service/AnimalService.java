/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.service;

import com.univpoitiers.fr.animalkeepermaven.dao.AnimalEntity;


/**
 *
 * @author edarles
 */
public interface AnimalService {
    
    public boolean add(String nom, String age, String type);
    public boolean remove(String nom);
    public AnimalEntity find(String nom);
    public String printAnimals();
}
