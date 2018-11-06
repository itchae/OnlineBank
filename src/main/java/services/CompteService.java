/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.BankAccountEntity;
import entities.VirementEntity;
import java.util.List;

/**
 *
 * @author lucille
 */
public interface CompteService {
    public String getIntitule(String login);
    public String getSolde(String login);
    public String printListAccount(String login);
    public String printAccount(String login);
    public void remplir(String intitule, double solde);
    public String compteRole(String login);
    public List<BankAccountEntity> getAccount(String login);
    public List<VirementEntity> getFrom(long id);
    public List<VirementEntity> getTo(long id);
    public String printFrom(long id);
    public String printTo(long id);
}
