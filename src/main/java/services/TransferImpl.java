/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BankAccountDAO;
import entities.BankAccountEntity;
import dao.CompteDAO;
import entities.CompteEntity;
import dao.VirementDAO;
import entities.VirementEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucille
 */
@Service
public class TransferImpl implements TransferService{

    @Autowired
    private VirementDAO vir; 
    
    @Autowired
    private BankAccountDAO ba; 
    
    /*@Override
    public void mouvement(String intitule, double solde, CompteEntity compte1, CompteEntity compte2) {
        VirementEntity v = new VirementEntity(intitule, solde, compte1, compte2);
        vir.save(v);
    }*/

    @Override
    public List<VirementEntity> getMouvement(long id) {
        return null; 
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, noRollbackFor=Exception.class)
    public boolean ajoutTransfert(String intitule, String solde, String compte1, String compte2) {
        Long c1 = (Long)Long.parseLong(compte1);
        Long c2 = (Long)Long.parseLong(compte2);
        
        BankAccountEntity debiteur = ba.find(c2);
        BankAccountEntity debite = ba.find(c1);
        if (debiteur==null || debite==null || Double.parseDouble(solde)<0){
            return false; 
        }
        
        /*if (l_debiteur.size()==1){
            debiteur = l_debiteur.get(0);
        }else{
            return false;
        }*/
        VirementEntity v = new VirementEntity(intitule, Double.parseDouble(solde), debiteur, debite);
        debiteur.addEnvoi(v);
        debite.addRecu(v);
        ba.update(debite);
        ba.update(debiteur);
        ba.save(debite);
        ba.save(debiteur);
        vir.save(v);
        
        return true; 
    }
    
}
