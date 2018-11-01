/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BankAccountDAO;
import dao.BankAccountEntity;
import dao.BanquierDAO;
import dao.BanquierEntity;
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
    boolean isAdded = false;
    
    @Autowired
    ParticulierDAO p;
    
    @Autowired
    BankAccountDAO b;
    
    @Autowired
    BanquierDAO bank;
    
    ParticulierService ps;
    CompteService c;
    BanquierService bq;
    
    
    @Override
    public void InitService() {
        CompteEntity c = new ParticulierEntity("Charles", 0, "ok", "Henri", "ok", "Lemail", "0605040201", "Adresse");
        CompteEntity c2 = new ParticulierEntity("Yves", 0, "toto", "Apabien", "tata", "Lemail", "0605040201", "Adresse");
        BankAccountEntity ba = new BankAccountEntity("Compte1", 1000);
        BankAccountEntity ba2 = new BankAccountEntity("Compte2", 200);
        BankAccountEntity ba3 = new BankAccountEntity("Compte3", 300);
        c2.addBA(ba3);
        c2.addBA(ba2);
        BanquierEntity b = new BanquierEntity("tom", "toto", "bonnion", "tata", "tom@bonnion.fr", "impasse du diable", "0606060606");
        bank.save(b);
        c.addBA(ba);
        c.addBA(ba2);
        p.save(c);
        p.save(c2);
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
