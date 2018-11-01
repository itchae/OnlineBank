/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BankAccountDAO;
import dao.BankAccountEntity;
import dao.CompteDAO;
import dao.CompteEntity;
import dao.ParticulierEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucille
 */
@Service
public class CompteImpl implements CompteService{
    @Autowired
    private BankAccountDAO bankAccountDao;
    
    @Autowired
    private CompteDAO c;
    
    @Override
    public String printAccount(long id) {
        CompteEntity ce = this.c.find(id);
        // Regarder si particulier, pro ou banquier ? 
        
        List<BankAccountEntity> bankAccount = ce.getBa();
        //List<BankAccountEntity> bankAccount = this.bankAccountDao.findAll();
        String result="";
        for(int i=0; i<bankAccount.size();i++){
            result +="<li><a href=#>"+bankAccount.get(i).toString()+"</a></li>";
            //List<CompteEntity> comptes = bankAccount.get(i).getUser();
            //result += comptes;
            //for(int j=0; j<comptes.size(); j++){
                //result += "<p>"+j+"</p>";
                //if(comptes.get(j).getId() == id){
                    //
                //}
            //}
        }
        return result;
    }

    @Override
    public String getIntitule(long id) {
        return this.getIntitule(id);
    }

    @Override
    public String getSolde(long id) {
        return this.getSolde(id);
    }

    @Override
    public void remplir(String intitule, double solde) {
        BankAccountEntity baEntity = new BankAccountEntity(intitule, solde);
        bankAccountDao.save(baEntity);
        
    }

    
}
