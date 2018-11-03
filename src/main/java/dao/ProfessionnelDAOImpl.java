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
public class ProfessionnelDAOImpl implements ProfessionnelDAO{

    @PersistenceContext(unitName="PersonnePU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(CompteEntity pro) {
        pro = em.merge(pro);
    }

    @Transactional
    @Override
    public void update(ProfessionnelEntity pro) {
        em.merge(pro);
    }

    @Transactional
    @Override
    public void delete(ProfessionnelEntity pro) {
        pro = em.merge(pro);
        em.remove(pro);
    }

    @Transactional(readOnly = true)
    @Override
    public ProfessionnelEntity find(long id) {
        return em.find(ProfessionnelEntity.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProfessionnelEntity> findAll() {
        Query q = em.createQuery("SELECT h FROM HelloEntity h");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProfessionnelEntity> findByName(String nom) {
        Query q = em.createQuery("SELECT pro FROM ProfessionnelEntity pro WHERE pro.nom = ? ").setParameter(1, nom);
        return q.getResultList();
    }
    
}
