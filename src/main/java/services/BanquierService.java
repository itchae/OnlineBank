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
    public String getLogin(long id);
    public String getMdp(long id);
    public String getEmail(long id);
    public String getPhone(long id);
    public String getAdresse(long id);
}
