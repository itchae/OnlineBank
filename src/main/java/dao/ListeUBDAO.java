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
public interface ListeUBDAO {
    public void save(ListeUBEntity c);
    public void update(ListeUBEntity c);
    public void delete(ListeUBEntity c);
    public ListeUBEntity find(long id);
    public List<ListeUBEntity> findAll();
}
