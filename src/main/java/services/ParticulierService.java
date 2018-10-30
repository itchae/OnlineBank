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

public interface ParticulierService {

    public String getLogin(long id);
    public String getMdp(long id);
    public String getEmail(long id);
    public String getPhone(long id);
    public String getAdresse(long id);
    public boolean tryConnect(String login, String pwd);
    public void remplirdb(String nom, String prenom, String login, String mdp, String email, String phone, String adress, long idBanquier);
    public String printComptes();
    
}
