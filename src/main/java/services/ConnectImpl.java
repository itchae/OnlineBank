/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CompteDAO;
import entities.CompteEntity;
import dao.ParticulierDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucille
 */
@Service("ConnectService")
public class ConnectImpl implements ConnectService{
    
    @Autowired
    private CompteDAO compteDao;
    

    @Override
    public String welcome(String nom) {
        return "Bienvenue "+ nom;
    }
    
    @Override
    public String connection(String login, String pwd){
        CompteEntity entity = compteDao.find(login);
        String pwdEntre = entity.getPassword();
        if(pwd.equals(pwdEntre)){
                return entity.getLogin();
        }
        return null;
    }
    
    
    
}
