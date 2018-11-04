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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author tbonnion
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(uniqueConstraints = {@UniqueConstraint(name = "usr_login", columnNames = { "login" }) })
public class CompteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public CompteEntity() {
    }

    public CompteEntity(String login, String nom, String password, String mail, String adresse, String tel) {
        this.login = login;
        this.nom = nom;
        this.password = password;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }
    
    @Id
    @Column(name = "login")
    private String login;
    
    @Column (name="nom")
    private String nom;

    @Column (name="password")
    private String password;
    
    @Column (name="mail")
    private String mail;
    
    @Column (name="adresse")
    private String adresse;
    
    @Column (name="tel")
    private String tel;
    
    @JoinTable(
    name="ListeBA_User",
    joinColumns=@JoinColumn(name="id_user"),
    inverseJoinColumns=@JoinColumn(name="id_compte")
    )
    @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<BankAccountEntity> ba = new ArrayList<BankAccountEntity>(); 
    
    

    public List<BankAccountEntity> getBa() {
        return ba;
    }

    public void setBa(List<BankAccountEntity> ba) {
        this.ba = ba;
    }
    
    
    
    public void addBA(BankAccountEntity newba){
        this.ba.add(newba);
        newba.getUser().add(this);
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
 
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteEntity)) {
            return false;
        }
        CompteEntity other = (CompteEntity) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.CompteEntity[ login=" + login + " ]";
    }
    
}
