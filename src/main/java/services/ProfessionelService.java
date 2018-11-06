/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author lucille
 */
public interface ProfessionelService {
    public String getLogin(String login);
    public String getMdp(String login);
    public String getEmail(String login);
    public String getPhone(String login);
    public String getAdresse(String login);
    public String getSiret(String login);
    public String getTypeEntreprise(String login);
    public void setMdp(String login,String value);
    public void setEmail(String login,String value);
    public void setAdresse(String login,String value);
    public void setPhone(String login,String value);
    public void setSiret(String login,String value);
    public boolean tryConnect(String login, String pwd);
    public String getBanquier(String id);
    
}
