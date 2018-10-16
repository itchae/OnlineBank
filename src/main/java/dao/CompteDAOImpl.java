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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tbonnion
 */
public class CompteDAOImpl implements CompteDAO{

    @PersistenceContext(unitName="OnlineBankPU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(CompteEntity comp) {
        comp = em.merge(comp);
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
    
}
