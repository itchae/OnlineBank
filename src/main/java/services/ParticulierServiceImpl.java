/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.univpoitiers.fr.animalkeepermaven.dao.AnimalEntity;
import dao.BankAccountDAO;
import dao.BankAccountEntity;
import dao.CompteDAO;
import dao.CompteEntity;
import dao.ParticulierDAO;
import dao.ParticulierEntity;
import dao.ProfessionnelEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucille
 */
@Service
public class ParticulierServiceImpl implements ParticulierService{

    @Autowired
   private ParticulierDAO particulierDao;
    
    @Autowired
    private CompteDAO compteDao;
    
    @Autowired
    private BankAccountDAO baDao; 

    public ParticulierDAO getParticulierDao() {
        return particulierDao;
    }
    
    @Override
    public String remplirdb(String nom, String prenom, String login, String mdp, String email, String phone, String adress, long idBanquier){
        CompteEntity p = new ParticulierEntity(prenom, idBanquier, login, nom, mdp, email, phone, adress);
        BankAccountEntity ba = new BankAccountEntity("Coucou", 1000);
        BankAccountEntity ba2 = new BankAccountEntity("Hello", 200);
        //baDao.save(ba);
        //baDao.save(ba2);
        //ba.addUser(p);
        p.addBA(ba);
        //ba2.addUser(p);
        p.addBA(ba2);
        particulierDao.save(p);
        //baDao.save(ba);
        //baDao.save(ba2);
        return "C'est save ";
    }
    
    @Override
    public String getLogin(long id) {
        return this.particulierDao.find(id).getLogin();
    }

    @Override
    public String getMdp(long id) {
        return this.particulierDao.find(id).getPassword();
    }

    @Override
    public String getEmail(long id) {
        return this.particulierDao.find(id).getMail();
                
    }

    @Override
    public String getPhone(long id) {
        return this.particulierDao.find(id).getTel();
    }

    @Override
    public String getAdresse(long id) {
        return this.particulierDao.find(id).getAdresse();
    }

    @Override
    public boolean tryConnect(String login, String pwd) {
        List<ParticulierEntity> listePar = this.particulierDao.findAll();
        String pwdTrue = "";
        boolean res = false; 
        int index = listePar.indexOf(login);
        if (index != -1){
            pwdTrue = listePar.get(index).getPassword();
            if (pwd.equals(pwdTrue)){
                res = true; 
            }
        }
        return res;
    }

    @Override
    public String printComptes() {
        List<ParticulierEntity> particulier = this.particulierDao.findAll();
        String result="";
        for(int i=0;i<particulier.size();i++){
            //result += i;
            result += "<P>Particulier " + i +"</P>";
            result += "<P> "+particulier.get(i).toString()+"</P>";
        }
        //result = "On va faire un jeu";      
        return result;
    }
    
}
