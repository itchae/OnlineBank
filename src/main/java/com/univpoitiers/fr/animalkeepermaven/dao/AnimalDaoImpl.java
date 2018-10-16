/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author edarles
 */
@Repository
public class AnimalDaoImpl implements AnimalDao {
  
    // Le contexte de persistance est décrit dans le fichier hibernate persistence.xml
    @PersistenceContext(unitName="AnimalKeeperJPAPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    @Override
    public void save(AnimalEntity a)
    {
        
        // Appel de la méthode merge pour l'ajouter au contexte de persistence 
        a = em.merge(a);
        // Appel de la méthode persist pour l'ajouter dans la BD
        em.persist(a);
    }
            
    
    @Transactional
    @Override
    public void update(AnimalEntity a)
    {
        em.merge(a);
    }
    
    @Transactional
    @Override
    public void delete(AnimalEntity a)
    {
        a = em.merge(a);
        em.remove(a);
    }
    
    @Transactional
    @Override
    public void addKeeper(AnimalEntity a, KeeperEntity k)
    {
        a = em.merge(a);
        a.addKeeper(k);
        save(a);
    }
    
    @Transactional(readOnly = true)
    @Override
    public AnimalEntity find(String nom)
    {
        return em.find(AnimalEntity.class, nom);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<AnimalEntity> findAll()
    {
        Query q = em.createQuery("SELECT a FROM AnimalEntity a");
        return q.getResultList();
    }
}
