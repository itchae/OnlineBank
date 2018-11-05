/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.BanquierEntity;
import entities.CompteEntity;
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
public class BanquierDAOImpl implements BanquierDAO {
    
    @PersistenceContext(unitName="PersonnePU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(CompteEntity b) {
        b = em.merge(b);
        em.persist(b);
    }

    @Transactional
    @Override
    public void update(BanquierEntity b) {
        em.merge(b);
    }

    @Transactional
    @Override
    public void delete(BanquierEntity b) {
        b = em.merge(b);
        em.remove(b);
    }

    @Transactional
    @Override
    public BanquierEntity find(String id) {
        return em.find(BanquierEntity.class, id);
    }

    @Transactional
    @Override
    public List<BanquierEntity> findAll() {
        Query q = em.createQuery("SELECT b FROM BanquierEntity b");
        return q.getResultList();
    }

    @Transactional(readOnly=true)
    @Override
    public List<BanquierEntity> findByName(String nom) {
        Query q = em.createQuery("SELECT b FROM CompteEntity b WHERE b.login = ? ").setParameter(1, nom);
        return q.getResultList();
    }
    
}
