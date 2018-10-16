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
    public String getLogin();
    public String getMdp(int id);
    public String getEmail(int id);
    public String getPhone(int id);
    public String getAdresse(int id);
    public boolean tryConnect(String login, String pwd);
    
}
