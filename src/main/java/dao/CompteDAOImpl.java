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
 * @author tbonnion
 */
@Repository
public class CompteDAOImpl implements CompteDAO{

    @PersistenceContext(unitName="PersonnePU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(CompteEntity comp) {
        //if(this.findByLogin(comp.getLogin()).size()<1){
            comp = em.merge(comp);
            em.persist(comp);
        //}
        
    }

    @Transactional
    @Override
    public void update(CompteEntity comp) {
        em.merge(comp);
    }

    @Transactional
    @Override
    public void delete(CompteEntity comp) {
        comp = em.merge(comp);
        em.remove(comp);
    }

    @Transactional(readOnly = true)
    @Override
    public CompteEntity find(long id) {
        return em.find(CompteEntity.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CompteEntity> findAll() {
        Query q = em.createQuery("SELECT c FROM CompteEntity c");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<CompteEntity> findByName(String nom) {
        Query q = em.createQuery("SELECT c FROM CompteEntity c WHERE c.nom = ? ").setParameter(1, nom);
        return q.getResultList();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<CompteEntity> findByLogin(String login) {
        Query q = em.createQuery("SELECT c FROM CompteEntity c WHERE c.login = ? ").setParameter(1, login);
        return q.getResultList();
    }
    
    
}
