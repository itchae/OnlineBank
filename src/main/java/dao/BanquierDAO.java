/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author lucille
 */
public interface BanquierDAO {
    public void save(BanquierEntity c);
    public void update(BanquierEntity c);
    public void delete(BanquierEntity c);
    public BanquierEntity find(long id);
    public List<BanquierEntity> findAll();
    public List<BanquierEntity> findByName(String nom);
}
