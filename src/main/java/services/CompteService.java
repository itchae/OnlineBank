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
public interface CompteService {
    public String getIntitule(long id);
    public String getSolde(long id);
    public String printAccount(long id);
    public void remplir(String intitule, double solde);
    public String compteRole(long id);
}
