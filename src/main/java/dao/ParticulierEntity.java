/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author lucille
 */
@Entity
public class ParticulierEntity extends CompteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String nom;
    
    @Column
    private String prenom;
    
    @Column 
    private String email;
    
    @Column
    private String adresse;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom; 
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom; 
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email; 
    }

    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public Long getId() {
        return id;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticulierEntity)) {
            return false;
        }
        ParticulierEntity other = (ParticulierEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.ParticulierEntity[ id=" + id + " ]";
    }
    
}
