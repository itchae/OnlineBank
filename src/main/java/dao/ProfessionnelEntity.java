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
 * @author tbonnion
 */
@Entity
public class ProfessionnelEntity extends CompteEntity {
    
    
    @Column (name="siret", unique=true)
    private String siret;

    
    @Column (name="type_entreprise")
    private String type_entreprise;
    
    @Column (name="idBanquier")
    private long idBanquier;
    
    public ProfessionnelEntity(){
        
    }
    
    public ProfessionnelEntity(String login, String nom, String password, String mail, String adresse, String tel,String siret, String type){
        super(login, nom, password, mail, adresse, tel);
        this.siret = siret;
        this.type_entreprise = type;
    }
    
    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }
    
    public String getType_entreprise() {
        return type_entreprise;
    }

    public void setType_entreprise(String type_entreprise) {
        this.type_entreprise = type_entreprise;
    }
/*              *******************************************                         */
/*              *******************************************                         */
/*              *******************************************                         */
/*              *******************************************                         */
/*              *******************************************                         */
    
    

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
