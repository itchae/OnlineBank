/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CompteDAO;
import dao.CompteEntity;
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
    public long connection(String login, String pwd){
        List<CompteEntity> list = compteDao.findByLogin(login);
        if(list.size()==1){
            String pwdEntre = list.get(0).getPassword();
            if(pwd.equals(pwdEntre)){
                return list.get(0).getId();
            }
        }
        return -1;
    }
    
    
    
}
