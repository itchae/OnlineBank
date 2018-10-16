/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author edarles
 */
@Entity
public class KeeperEntity implements Serializable {
    private static final long serialVersionUID = 1L;
  
    @Id
    String nom;
    
    @Column(nullable=false)
    String prenom;
    
    @Column
    String age;
    
    @Column
    String adresse;
    
    @JoinTable( 
        name="Keeper_Animal", 
        joinColumns=@JoinColumn(name="id_KeeperEntity"), 
        inverseJoinColumns=@JoinColumn(name="id_AnimalEntity") 
    ) 
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<AnimalEntity> animals = new ArrayList<AnimalEntity>();

    public KeeperEntity()
    {
        nom = "";
        prenom = "";
        age = "";
        adresse = "";
    }
    public KeeperEntity(String nom, String prenom, String age, String adresse)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
    }
  
    public KeeperEntity(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = "";
        this.adresse = "";
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAge() {
        return age;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<AnimalEntity> getAnimals()
    {
        return animals;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void setAnimals(List<AnimalEntity> animals)
    {
        this.animals = animals;
    }
    
    public void addAnimal(AnimalEntity animal)
    {
        this.animals.add(animal);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KeeperEntity)) {
            return false;
        }
        KeeperEntity other = (KeeperEntity) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nom=" + nom  + " Prenom="+ prenom + " Age=" + age +"]";
    }
    
}
