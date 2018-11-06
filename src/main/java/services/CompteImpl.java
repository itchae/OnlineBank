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
import entities.ParticulierEntity;
import entities.ProfessionnelEntity;
import entities.BanquierEntity;
import dao.VirementDAO;
import entities.VirementEntity;
import java.util.ArrayList;
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
    private VirementDAO vir; 
    
    @Autowired
    private CompteDAO c;
    
    @Override
    public String printAccount(String login) {
        CompteEntity ce = this.c.find(login);
        List<BankAccountEntity> bankAccount = ce.getBa();
        String result="";
        for(int i=0; i<bankAccount.size();i++){
            result +="<a href='consultAccount.htm?param="+bankAccount.get(i).getId()+"' class=\"list-group-item list-group-item-action\">"+bankAccount.get(i).toString()+"</a></li>";
        }
        return result;
    }
    
    @Override
    public String printListAccount(String login){
        CompteEntity ce = this.c.find(login);
        List<BankAccountEntity> bankAccount = ce.getBa();
        String result="";
        for(int i=0; i<bankAccount.size();i++){
            result +="<option>"+bankAccount.get(i).getId();
        }
        return result;
    }
    
    @Override
    public List<BankAccountEntity> getAccount(String login){
        CompteEntity ce = this.c.find(login);
        List<BankAccountEntity> bankAccount = ce.getBa();
        return bankAccount; 
    }

    @Override
    public String getIntitule(String id) {
        return this.getIntitule(id);
    }

    @Override
    public String getSolde(String id) {
        return this.getSolde(id);
    }

    @Override
    public void remplir(String intitule, double solde) {
        BankAccountEntity baEntity = new BankAccountEntity(intitule, solde);
        bankAccountDao.save(baEntity);
        
    }

    @Override
    public String compteRole(String id) {
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
    
    @Override
    public List<VirementEntity> getFrom(long id){
        BankAccountEntity b = bankAccountDao.find(id);
        List<VirementEntity> liste = vir.findAll();
        List<VirementEntity> res = new ArrayList<VirementEntity>();
        for(int i=0 ; i<liste.size() ; i++){
            if(liste.get(i).getIdActeur().equals(b)){
                res.add(liste.get(i));
            }
        }
        return res;
    } 
    
    @Override
    public List<VirementEntity> getTo(long id){
        BankAccountEntity b = bankAccountDao.find(id);
        List<VirementEntity> liste = vir.findAll();
        List<VirementEntity> res = new ArrayList<VirementEntity>();
        for(int i=0 ; i<liste.size() ; i++){
            if(liste.get(i).getIdRecepteur().equals(b)){
                res.add(liste.get(i));
            }
        }
        return res;
    }

    @Override
    public String printFrom(long id) {
        BankAccountEntity b = bankAccountDao.find(id);
        List<VirementEntity> liste = vir.findAll();
        List<VirementEntity> res = new ArrayList<VirementEntity>();
        String affichage = ""; 
        for(int i=0 ; i<liste.size() ; i++){
            if(liste.get(i).getIdActeur().equals(b)){
                affichage += "<li class=\"list-group-item list-group-item-success\"> ";
                affichage += liste.get(i).getIntitule();
                affichage += " ";
                affichage += liste.get(i).getMontant();
                affichage += " ";
                affichage += liste.get(i).getIdRecepteur().getId();
                affichage += "</li>";
                
            }
        }
        return affichage;
    }

    @Override
    public String printTo(long id) {
        BankAccountEntity b = bankAccountDao.find(id);
        List<VirementEntity> liste = vir.findAll();
        List<VirementEntity> res = new ArrayList<VirementEntity>();
        String affichage = ""; 
        for(int i=0 ; i<liste.size() ; i++){
            if(liste.get(i).getIdRecepteur().equals(b)){
                affichage += "<li class=\"list-group-item list-group-item-danger\"> ";
                affichage += liste.get(i).getIntitule();
                affichage += " ";
                affichage += liste.get(i).getMontant();
                affichage += " ";
                affichage += liste.get(i).getIdActeur().getId();
                affichage += "</li>";
                
            }
        }
        return affichage;
    }

    
}
