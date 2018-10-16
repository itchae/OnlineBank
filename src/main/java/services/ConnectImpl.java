/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import org.springframework.stereotype.Service;

/**
 *
 * @author lucille
 */
@Service("ConnectService")
public class ConnectImpl implements ConnectService{

    @Override
    public String welcome(String nom) {
        return "Bienvenue "+ nom;
    }
    
    @Override
    public boolean connection(String mdp, String pwd){
        return true; 
    }
    
}
