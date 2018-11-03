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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucille
 */
@Entity
public class VirementEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column (name="intitule")
    private String intitule;
    
    @Column (name="montant")
    private double montant;

    @ManyToOne
    @JoinColumn(name="envoi")
    private BankAccountEntity idActeur;
    
    @ManyToOne
    @JoinColumn(name="reception")
    private BankAccountEntity idRecepteur; 

    public VirementEntity(String intitule, double montant, BankAccountEntity idActeur, BankAccountEntity idRecepteur) {
        this.intitule = intitule;
        this.montant = montant;
        this.idActeur = idActeur;
        this.idRecepteur = idRecepteur;
    }

    public VirementEntity() {
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public BankAccountEntity getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(BankAccountEntity idActeur) {
        this.idActeur = idActeur;
    }

    public BankAccountEntity getIdRecepteur() {
        return idRecepteur;
    }

    public void setIdRecepteur(BankAccountEntity idRecepteur) {
        this.idRecepteur = idRecepteur;
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

        return true;
    }

    @Override
    public String toString() {
        return "dao.CompteEntity[ id=" + id + " ]";
    }
    

}
