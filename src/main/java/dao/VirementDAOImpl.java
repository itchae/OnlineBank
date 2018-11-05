/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.VirementEntity;
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
public class VirementDAOImpl implements VirementDAO{

    @PersistenceContext(unitName="PersonnePU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(VirementEntity v) {
        v = em.merge(v);
        em.persist(v);
    }

    @Transactional
    @Override
    public void update(VirementEntity v) {
        em.merge(v);
    }

    @Transactional
    @Override
    public void delete(VirementEntity v) {
        v = em.merge(v);
        em.remove(v);
    }

    @Transactional
    @Override
    public VirementEntity find(long id) {
        return em.find(VirementEntity.class, id);
    }

    @Transactional
    @Override
    public List<VirementEntity> findAll() {
        Query q = em.createQuery("SELECT h FROM VirementEntity h");
        return q.getResultList();
    }

    @Transactional
    @Override
    public List<VirementEntity> findFrom(long id) {
        Query q = em.createQuery("SELECT h FROM VirementEntity h WHERE h.idRecepteur = ?").setParameter(1, id);
        return q.getResultList();
    }
    
    @Transactional
    @Override
    public List<VirementEntity> findTo(long id) {
        Query q = em.createQuery("SELECT h FROM VirementEntity h WHERE h.idActeur = ?").setParameter(1, id);
        return q.getResultList();
    }
    
}
