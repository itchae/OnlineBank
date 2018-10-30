/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author lucille
 */
@Entity
public class ListVirEntity implements Serializable {
    
    @Id
    private String idCompte;
    
    @Id
    private String idVir;

    public long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(long idCompte) {
        this.idCompte = idCompte;
    }

    public long getIdVir() {
        return idVir;
    }

    public void setIdVir(long idVir) {
        this.idVir = idVir;
    }
    
    
    
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        
        return true;
    }

    @Override
    public String toString() {
        return "dao.CompteEntity[ id=" + " ]";
    }
}
