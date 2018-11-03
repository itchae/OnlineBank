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
    public String getLogin(long id);
    public String getMdp(long id);
    public String getEmail(long id);
    public String getPhone(long id);
    public String getAdresse(long id);
    public String getSiret(long id);
    public String getTypeEntreprise(long id);
    public void setMdp(long id,String value);
    public void setEmail(long id,String value);
    public void setAdresse(long id,String value);
    public void setPhone(long id,String value);
    public void setSiret(long id,String value);
    public boolean tryConnect(String login, String pwd);
    
}
