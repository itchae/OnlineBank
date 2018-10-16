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
public class AnimalEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    String nom;
    
    @Column
    String age;
    
    @Column (nullable=false)
    String type;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "animals", cascade = CascadeType.ALL) 
    List<KeeperEntity> keepers = new ArrayList<KeeperEntity>();

    public AnimalEntity()
    {
        nom = "";
        age = "";
        type = "";
    }
    
    public AnimalEntity(String nom, String age, String type)
    {
        this.nom = nom;
        this.age = age;
        this.type = type;
    }
    
    public AnimalEntity(String nom, String type)
    {
        this.nom = nom;
        this.age = "";
        this.type = type;
    }
     
    public String getNom() {
        return nom;
    }
    public String getAge() {
        return age;
    }
    public String getType() {
        return type;
    }
    public List<KeeperEntity> getKeepers()
    {
        return keepers;
    }
   
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setKeepers(List<KeeperEntity> keepers)
    {
        this.keepers = keepers;
    }
    public void addKeeper(KeeperEntity keeper)
    {
        this.keepers.add(keeper);
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
        if (!(object instanceof AnimalEntity)) {
            return false;
        }
        AnimalEntity other = (AnimalEntity) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[nom= "+ nom + " age="+ age + " type="+ type + "]";
    }
    
}
