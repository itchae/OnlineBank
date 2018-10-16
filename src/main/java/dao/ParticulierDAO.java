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
public interface ParticulierDAO {
    public void save(ParticulierEntity h);
    public void update(ParticulierEntity h);
    public void delete(ParticulierEntity h);
    public ParticulierEntity find(long id);
    public List<ParticulierEntity> findAll();
    public List<ParticulierEntity> findByName(String nom);
}
