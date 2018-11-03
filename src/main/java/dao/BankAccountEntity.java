/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucille
 */
@Table(name="BankAccountEntity")
@Entity
public class BankAccountEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column (name = "intitule")
    private String intitule; 
    
    @Column (name = "solde")
    private double solde;
    
    @ManyToMany(mappedBy = "ba")
    List<CompteEntity> user = new ArrayList<CompteEntity>(); 
    
    @OneToMany(mappedBy="idRecepteur") 
    List<VirementEntity> recu = new ArrayList<VirementEntity>();
    
    @OneToMany(mappedBy="idActeur") 
    List<VirementEntity> envoi = new ArrayList<VirementEntity>();

    public List<CompteEntity> getUser() {
        return user;
    }
    
    public void addUser(String login, String nom, String password, String mail, String adresse, String tel){
        CompteEntity c = new CompteEntity(login, nom, password, mail, adresse, tel);
        this.user.add(c);
    }
    
    public void addUser(CompteEntity c){
        this.user.add(c);
    }

    public BankAccountEntity() {
    }

    public BankAccountEntity(String intitule, double solde) {
        this.intitule = intitule;
        this.solde = solde;
    }

    public void addRecu(VirementEntity v){
        this.recu.add(v);
    }
    
    public void addEnvoi(VirementEntity v){
        this.envoi.add(v);
    }
    
    public List<VirementEntity> getRecu() {
        return recu;
    }

    public void setRecu(List<VirementEntity> recu) {
        this.recu = recu;
    }

    public List<VirementEntity> getEnvoi() {
        return envoi;
    }

    public void setEnvoi(List<VirementEntity> envoi) {
        this.envoi = envoi;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
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
        if (!(object instanceof BankAccountEntity)) {
            return false;
        }
        BankAccountEntity other = (BankAccountEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id : " + id + " Intitule : "+ intitule + " Solde : "+ solde;
    }
    
    
    
}
