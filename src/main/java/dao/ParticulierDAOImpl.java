/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucille
 */
@Repository
public class ParticulierDAOImpl implements ParticulierDAO{

    @PersistenceContext(unitName="PersonnePU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(CompteEntity pers) {
        //if(findByLogin(pers.getLogin()).size()<1){
            pers = em.merge(pers);
            em.persist(pers);
        //}
    }

    @Transactional
    @Override
    public void update(ParticulierEntity pers) {
        em.merge(pers);
    }

    @Transactional
    @Override
    public void delete(ParticulierEntity pers) {
        pers = em.merge(pers);
        em.remove(pers);
    }

    @Transactional(readOnly = true)
    @Override
    public ParticulierEntity find(long id) {
        return em.find(ParticulierEntity.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ParticulierEntity> findAll() {
        Query q = em.createQuery("SELECT p FROM ParticulierEntity p");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ParticulierEntity> findByName(String nom) {
        Query q = em.createQuery("SELECT pers FROM ParticulierEntity p WHERE p.nom = ? ").setParameter(1, nom);
        return q.getResultList();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<CompteEntity> findByLogin(String login) {
        Query q;
        q = em.createQuery("SELECT pers FROM CompteEntity p WHERE p.login = ? ").setParameter(1, login);
        return q.getResultList();
        //return null; 
    }
  
}
