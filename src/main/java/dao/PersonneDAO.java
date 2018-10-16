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
public interface PersonneDAO {
    public void save(PersonneEntity h);
    public void update(PersonneEntity h);
    public void delete(PersonneEntity h);
    public PersonneEntity find(long id);
    public List<PersonneEntity> findAll();
    public List<PersonneEntity> findByName(PersonneEntity h, String nom);
}
