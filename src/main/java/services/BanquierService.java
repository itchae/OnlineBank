/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author APO
 */
public interface BanquierService {
    public boolean addBanquier(String nom, String prenom, String login, String mdp, String email, String phone, String adresse);
    public String getLogin(String id);
    public String getMdp(String id);
    public String getEmail(String id);
    public String getPhone(String id);
    public String getAdresse(String id);
    public String getPrenom(String id);
    public String getNom(String id);
    public void setMdp(String id,String value);
    public void setEmail(String id,String value);
    public void setAdresse(String id,String value);
    public void setPhone(String id,String value);
    public void setPrenom(String id,String value);
}
