/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.univpoitiers.fr.animalkeepermaven.dao.AnimalEntity;
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

    public ParticulierDAO getParticulierDao() {
        return particulierDao;
    }
    
    @Override
    public String getLogin(int id) {
        return this.particulierDao.find(id).getLogin();
    }

    @Override
    public String getMdp(int id) {
        return this.particulierDao.find(id).getPassword();
    }

    @Override
    public String getEmail(int id) {
        return this.particulierDao.find(id).getMail();
                
    }

    @Override
    public String getPhone(int id) {
        return this.particulierDao.find(id).getTel();
    }

    @Override
    public String getAdresse(int id) {
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
