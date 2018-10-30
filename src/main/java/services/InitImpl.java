/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BankAccountDAO;
import dao.ParticulierDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucille
 */
public class InitImpl implements InitService{
    boolean isAdded;
    
    @Autowired
    ParticulierDAO p;
    
    @Autowired
    BankAccountDAO b; 
    
    ParticulierService ps; 
    CompteService c; 
    
    
    @Override
    public void InitService() {
        this.isAdded=false; 
    }

    @Override
    public void remplissage() {
        if(!this.isAdded){
            ps.remplirdb("Jean", "René", "toto", "tata", "toto@tata.jean", "0606060606", "1 rue guillotine", 0);
            c.remplir("Lecompte", 300);
            this.isAdded = true; 
        }
    }
    
}
