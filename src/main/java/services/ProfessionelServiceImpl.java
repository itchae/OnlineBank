/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProfessionnelDAO;
import entities.ProfessionnelEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucille
 */
@Service
public class ProfessionelServiceImpl implements ProfessionelService{

    @Autowired
    ProfessionnelDAO proDao; 

    @Override
    public boolean tryConnect(String login, String pwd) {
        List<ProfessionnelEntity> listePro = this.proDao.findAll();
        String pwdTrue = "";
        boolean res = false; 
        int index = listePro.indexOf(login);
        if (index != -1){
            pwdTrue = listePro.get(index).getPassword();
            if (pwd.equals(pwdTrue)){
                res = true; 
            }
        }
        return res;
    }

    @Override
    public String getLogin(String id) {
        return proDao.find(id).getLogin();
    }

    @Override
    public String getMdp(String id) {
        return proDao.find(id).getPassword();
    }

    @Override
    public String getEmail(String id) {
        return proDao.find(id).getMail();
    }

    @Override
    public String getPhone(String id) {
        return proDao.find(id).getTel();
    }

    @Override
    public String getAdresse(String id) {
        return proDao.find(id).getAdresse();
    }

    @Override
    public String getSiret(String id) {
        return proDao.find(id).getSiret();
    }

    @Override
    public String getTypeEntreprise(String id) {
        return proDao.find(id).getType_entreprise();
    }

    @Override
    public void setMdp(String id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setPassword(value);
        this.proDao.update(p);
    }

    @Override
    public void setEmail(String id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setMail(value);
        this.proDao.update(p);
    }

    @Override
    public void setAdresse(String id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setAdresse(value);
        this.proDao.update(p);
    }

    @Override
    public void setPhone(String id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setTel(value);
        this.proDao.update(p);
    }

    @Override
    public void setSiret(String id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setSiret(value);
        this.proDao.update(p);
    }
    
}
