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
 * @author lucille
 */
public class PersonneDAOImpl implements PersonneDAO{

    @PersistenceContext(unitName="PersonnePU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(PersonneEntity pers) {
        pers = em.merge(pers);
    }

    @Transactional
    @Override
    public void update(PersonneEntity pers) {
        em.merge(pers);
    }

    @Transactional
    @Override
    public void delete(PersonneEntity pers) {
        pers = em.merge(pers);
        em.remove(pers);
    }

    @Transactional(readOnly = true)
    @Override
    public PersonneEntity find(long id) {
        return em.find(PersonneEntity.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonneEntity> findAll() {
        Query q = em.createQuery("SELECT h FROM HelloEntity h");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<PersonneEntity> findByName(PersonneEntity pers, String nom) {
        Query q = em.createQuery("SELECT h FROM HelloEntity h WHERE h.nom = ? ").setParameter(1, nom);
        return q.getResultList();
    }
    
}
