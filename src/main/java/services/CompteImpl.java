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
import dao.ProfessionnelEntity;
import dao.BanquierEntity;
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
        List<BankAccountEntity> bankAccount = ce.getBa();
        String result="";
        for(int i=0; i<bankAccount.size();i++){
            result +="<li><a href='consultAccount.htm?param="+bankAccount.get(i).getId()+"'>"+bankAccount.get(i).toString()+"</a></li>";
        }
        return result;
    }
    
    @Override
    public List<BankAccountEntity> getAccount(long id){
        CompteEntity ce = this.c.find(id);
        List<BankAccountEntity> bankAccount = ce.getBa();
        return bankAccount; 
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

    @Override
    public String compteRole(long id) {
        if (this.c.find(id) instanceof ParticulierEntity){
            return "par";
        }
        if (this.c.find(id) instanceof ProfessionnelEntity){
            return "pro";
        }
        if (this.c.find(id) instanceof BanquierEntity){
            return "banq";
        }
        return "err";
    }

    
}
