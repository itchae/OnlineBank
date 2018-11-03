/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProfessionnelDAO;
import dao.ProfessionnelEntity;
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
    public String getLogin(long id) {
        return proDao.find(id).getLogin();
    }

    @Override
    public String getMdp(long id) {
        return proDao.find(id).getPassword();
    }

    @Override
    public String getEmail(long id) {
        return proDao.find(id).getMail();
    }

    @Override
    public String getPhone(long id) {
        return proDao.find(id).getTel();
    }

    @Override
    public String getAdresse(long id) {
        return proDao.find(id).getAdresse();
    }

    @Override
    public String getSiret(long id) {
        return proDao.find(id).getSiret();
    }

    @Override
    public String getTypeEntreprise(long id) {
        return proDao.find(id).getType_entreprise();
    }

    @Override
    public void setMdp(long id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setPassword(value);
        this.proDao.update(p);
    }

    @Override
    public void setEmail(long id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setMail(value);
        this.proDao.update(p);
    }

    @Override
    public void setAdresse(long id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setAdresse(value);
        this.proDao.update(p);
    }

    @Override
    public void setPhone(long id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setTel(value);
        this.proDao.update(p);
    }

    @Override
    public void setSiret(long id, String value) {
        ProfessionnelEntity p = this.proDao.find(id);
        p.setSiret(value);
        this.proDao.update(p);
    }
    
}
