/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author lucille
 */
@Entity
public class ParticulierEntity extends CompteEntity {
    
    @Column (name="prenom")
    private String prenom;
    
    @Column (name="idBanquier")
    private String idBanquier;

    public ParticulierEntity(String prenom, String idBanquier, String login, String nom, String password, String mail, String adresse, String tel) {
        super(login, nom, password, mail, adresse, tel);
        this.prenom = prenom;
        this.idBanquier = idBanquier;
    }

    public ParticulierEntity() {
    }

    

    public String getIdBanquier() {
        return idBanquier;
    }

    public void setIdBanquier(String idBanquier) {
        this.idBanquier = idBanquier;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom; 
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getLogin() != null ? super.getLogin().hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "nom : "+this.getNom()
                +" Prenom : "+this.getPrenom()
                +" Email : "+this.getMail();
        //return "dao.ParticulierEntity[ super.getId()=" /*+ super.getId() + " ]"*/;
    }
    
}
