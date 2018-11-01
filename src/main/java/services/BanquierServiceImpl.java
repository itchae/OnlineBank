/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BanquierDAO;
import dao.BanquierEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author APO
 */
public class BanquierServiceImpl implements BanquierService {

    @Autowired
    BanquierDAO banquierDao; 
    
    @Override
    public String getLogin(long id) {
        return banquierDao.find(id).getLogin();
    }

    @Override
    public String getMdp(long id) {
        return banquierDao.find(id).getPassword();
    }

    @Override
    public String getEmail(long id) {
        return banquierDao.find(id).getMail();
    }

    @Override
    public String getPhone(long id) {
        return banquierDao.find(id).getTel();
    }

    @Override
    public String getAdresse(long id) {
        return banquierDao.find(id).getTel();
    }

    @Override
    public void addBanquier(String nom, String prenom, String login, String mdp, String email, String phone, String adresse) {
        BanquierEntity p = new BanquierEntity(prenom, login, nom, mdp, email, phone, adresse);
        banquierDao.save(p);
    }

    
}