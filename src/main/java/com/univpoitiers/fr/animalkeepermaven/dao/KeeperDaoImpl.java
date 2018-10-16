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
public class KeeperDaoImpl implements KeeperDao {

    @PersistenceContext(unitName="AnimalKeeperJPAPU")
    EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    @Override
    public void save(KeeperEntity k) {
        k = em.merge(k);
        em.persist(k);
    }

    @Transactional
    @Override
    public void update(KeeperEntity k) {
        em.merge(k);
    }

    @Transactional
    @Override
    public void delete(KeeperEntity k) {
        k = em.merge(k);
        em.remove(k);
    }

    @Transactional
    @Override
    public void addAnimal(KeeperEntity k, AnimalEntity a){
        if(k!=null && a!=null){
            List<AnimalEntity> animals = k.getAnimals();
            List<KeeperEntity> keepers = a.getKeepers();
            if(!k.getAnimals().contains(a) && !a.getKeepers().contains(k)){
                k = em.merge(k);
                a = em.merge(a);
                k.addAnimal(a);
                a.addKeeper(k);
                em.persist(a);
                em.persist(k);
            }
        }
    }
    
    @Transactional
    @Override
    public KeeperEntity find(String nom)
    {
        return em.find(KeeperEntity.class, nom);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<KeeperEntity> findAll() {
        Query q = em.createQuery("SELECT k FROM KeeperEntity k");
        return q.getResultList();
    }
    
}
