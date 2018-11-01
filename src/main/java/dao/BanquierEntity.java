/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author lucille
 */
@Entity
public class BanquierEntity extends CompteEntity{
    @Column (name="prenom")
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public BanquierEntity(String prenom, String login, String nom, String password, String mail, String adresse, String tel){
        super(login, nom, password, mail, adresse, tel);
        this.prenom = prenom;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "dao.ProfessionnelEntity[ super.getId()=" + super.getId() + " ]";
    }
}
