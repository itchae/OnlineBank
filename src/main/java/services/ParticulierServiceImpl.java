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
import dao.ParticulierDAO;
import entities.ParticulierEntity;
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
    public String getLogin(String id) {
        return this.particulierDao.find(id).getLogin();
    }

    @Override
    public String getMdp(String id) {
        return this.particulierDao.find(id).getPassword();
    }

    @Override
    public String getEmail(String id) {
        return this.particulierDao.find(id).getMail();
                
    }

    @Override
    public String getPhone(String id) {
        return this.particulierDao.find(id).getTel();
    }

    @Override
    public String getAdresse(String id) {
        return this.particulierDao.find(id).getAdresse();
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

    @Override
    public String getBanquier(String id) {
        return this.particulierDao.find(id).getIdBanquier();
    }

    @Override
    public void setMdp(String id,String value) {
        ParticulierEntity p = this.particulierDao.find(id);
        p.setPassword(value);
        this.particulierDao.update(p);
    }

    @Override
    public void setEmail(String id,String value) {
        ParticulierEntity p = this.particulierDao.find(id);
        p.setMail(value);
        this.particulierDao.update(p);
    }

    @Override
    public void setAdresse(String id,String value) {
        ParticulierEntity p = this.particulierDao.find(id);
        p.setAdresse(value);
        this.particulierDao.update(p);
    }

    @Override
    public void setPhone(String id,String value) {
        ParticulierEntity p = this.particulierDao.find(id);
        p.setTel(value);
        this.particulierDao.update(p);
    }

    @Override
    public String getPrenom(String id) {
        return this.particulierDao.find(id).getPrenom();
    }

    @Override
    public void setPrenom(String id, String value) {
        ParticulierEntity p = this.particulierDao.find(id);
        p.setPrenom(value);
        this.particulierDao.update(p);
    }
    
}
