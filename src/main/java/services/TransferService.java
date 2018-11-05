/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CompteEntity;
import entities.VirementEntity;
import java.util.List;

/**
 *
 * @author lucille
 */
public interface TransferService {
    //public void mouvement(String intitule, double solde, CompteEntity compte1, CompteEntity compte2);
    public boolean ajoutTransfert(String intitule, String solde, String compte1, String compte2);

    public List<VirementEntity> getMouvement(long id);
}
