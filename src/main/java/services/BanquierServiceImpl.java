/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.BanquierDAO;
import dao.BanquierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author APO
 */
@Service
public class BanquierServiceImpl implements BanquierService {

    @Autowired
    BanquierDAO banquierDao; 

    public BanquierDAO getBanquierDao() {
        return banquierDao;
    }
        
    @Override
    public String getLogin(String id) {
        return banquierDao.find(id).getLogin();
    }

    @Override
    public String getMdp(String id) {
        return banquierDao.find(id).getPassword();
    }

    @Override
    public String getEmail(String id) {
        return banquierDao.find(id).getMail();
    }

    @Override
    public String getPhone(String id) {
        return banquierDao.find(id).getTel();
    }

    @Override
    public String getAdresse(String id) {
        return banquierDao.find(id).getTel();
    }

    @Override
    public boolean addBanquier(String nom, String prenom, String login, String mdp, String email, String phone, String adresse) {
        BanquierEntity p = new BanquierEntity(prenom, login, nom, mdp, email, phone, adresse);
        banquierDao.save(p);
        return true;
    }

    @Override
    public String getPrenom(String id) {
        return this.banquierDao.find(id).getPrenom();
    }

    @Override
    public void setMdp(String id, String value) {
        BanquierEntity p = this.banquierDao.find(id);
        p.setPassword(value);
        this.banquierDao.update(p);
    }

    @Override
    public void setEmail(String id, String value) {
        BanquierEntity p = this.banquierDao.find(id);
        p.setMail(value);
        this.banquierDao.update(p);
    }

    @Override
    public void setAdresse(String id, String value) {
        BanquierEntity p = this.banquierDao.find(id);
        p.setAdresse(value);
        this.banquierDao.update(p);
    }

    @Override
    public void setPhone(String id, String value) {
        BanquierEntity p = this.banquierDao.find(id);
        p.setTel(value);
        this.banquierDao.update(p);
    }

    @Override
    public void setPrenom(String id, String value) {
        BanquierEntity p = this.banquierDao.find(id);
        p.setPrenom(value);
        this.banquierDao.update(p);
    }

    
}
