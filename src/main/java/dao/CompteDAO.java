/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.CompteEntity;
import java.util.List;

/**
 *
 * @author tbonnion
 */
public interface CompteDAO {
    public void save(CompteEntity c);
    public void update(CompteEntity c);
    public void delete(CompteEntity c);
    public CompteEntity find(String login);
    public List<CompteEntity> findAll();
    public List<CompteEntity> findByName(String nom);
    public List<CompteEntity> findByLogin(String login);

    //public void save(BankAccountEntity ba);
}
