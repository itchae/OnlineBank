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
        CompteEntity c = new ParticulierEntity("Charles", 1, "ok", "Henri", "ok", "Lemail", "0605040201", "Adresse");
        BankAccountEntity ba = new BankAccountEntity("Compte1", 1000);
        BankAccountEntity ba2 = new BankAccountEntity("Compte2", 200);
        BankAccountEntity ba3 = new BankAccountEntity("Compte3", 300);
        
        c.addBA(ba);
        c.addBA(ba2);
        
        c2.addBA(ba3);
        c2.addBA(ba2);
        
        bank.save(b);
        p.save(c);
        p.save(c2);
    }
    
}
