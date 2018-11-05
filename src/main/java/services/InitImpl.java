/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BankAccountDAO;
import entities.BankAccountEntity;
import dao.BanquierDAO;
import entities.BanquierEntity;
import entities.CompteEntity;
import dao.ParticulierDAO;
import dao.ProfessionnelDAO;
import entities.ParticulierEntity;
import entities.ProfessionnelEntity;
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
    ProfessionnelDAO pro;
    
    @Autowired
    BankAccountDAO b;
    
    @Autowired
    BanquierDAO bank;
    
    ParticulierService ps;
    CompteService c;
    BanquierService bq;
    
    
    @Override
    public void InitService() {
        CompteEntity c = new ParticulierEntity("Charles", "Banquier1", "ok", "Henri", "ok", "Lemail", "Adresse", "0605040201");
        CompteEntity c3 = new ProfessionnelEntity("pro", "proland", "pro", "pro@pro.pro", "1 rue des pros", "3615", "812154136541", "EIRL");
        CompteEntity c2 = new ParticulierEntity("Charles", "Banquier1", "test", "Henri", "test", "Lemail", "Adresse", "0605040201");
        CompteEntity banquier = new BanquierEntity("Edouard", "Banquier1", "Leclerc", "ok", "coucou", "place marechal leclerc", "065959599595");
        BankAccountEntity ba = new BankAccountEntity("Compte1", 1000);
        BankAccountEntity ba2 = new BankAccountEntity("Compte2", 200);
        BankAccountEntity ba3 = new BankAccountEntity("Compte3", 300);
        
        c.addBA(ba);
        c.addBA(ba2);
        
        //c2.addBA(ba3);
        //c2.addBA(ba2);
        
        //bank.save(b);
        bank.save(banquier);
        p.save(c);
        pro.save(c3);
        //p.save(c2);
    }
    
}
