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
public class BankAccountDAOImpl implements BankAccountDAO{

    @PersistenceContext(unitName="PersonnePU")
    private EntityManager em;
    
    @Transactional
    @Override
    public void save(BankAccountEntity b) {
        
        //BankAccountEntity entite_attachee=em.merge(VirementEntity);
        em.merge(b);
        em.persist(b);
    }

    @Transactional
    @Override
    public void update(BankAccountEntity b) {
        em.merge(b);
    }

    @Transactional
    @Override
    public void delete(BankAccountEntity b) {
        b = em.merge(b);
        em.remove(b);
    }

    @Transactional(readOnly = true)
    @Override
    public BankAccountEntity find(long id) {
        return em.find(BankAccountEntity.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BankAccountEntity> findAll() {
        Query q;
        q = em.createQuery("SELECT b FROM BankAccountEntity b");
        return q.getResultList();
    }
    
}
