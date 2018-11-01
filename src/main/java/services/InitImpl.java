/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BankAccountDAO;
import dao.BankAccountEntity;
import dao.CompteEntity;
import dao.ParticulierDAO;
import dao.ParticulierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucille
 */
@Service
public class InitImpl implements InitService{
    boolean isAdded;
    
    @Autowired
    ParticulierDAO p;
    
    @Autowired
    BankAccountDAO b; 
    
    ParticulierService ps; 
    CompteService c;
    BanquierService bq;
    
    
    @Override
    public void InitService() {
        CompteEntity c = new ParticulierEntity("Charles", 0, "ok", "Henri", "ok", "Lemail", "0605040201", "Adresse");
        BankAccountEntity ba = new BankAccountEntity("Compte1", 1000);
        BankAccountEntity ba2 = new BankAccountEntity("Compte2", 200);
        c.addBA(ba);
        c.addBA(ba2);
        p.save(c);
    }

    @Override
    public void remplissage() {
        if(!this.isAdded){
            ps.remplirdb("Jean", "René", "toto", "tata", "toto@tata.jean", "0606060606", "1 rue guillotine", 1);
            c.remplir("Lecompte", 300);
            this.isAdded = true; 
        }
    }
    
}
