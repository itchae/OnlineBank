/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.BankAccountEntity;
import java.util.List;

/**
 *
 * @author lucille
 */
public interface BankAccountDAO {
    public void save(BankAccountEntity b);
    public void update(BankAccountEntity b);
    public void delete(BankAccountEntity b);
    public BankAccountEntity find(long id);
    public List<BankAccountEntity> findAll();
}
