/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.VirementEntity;
import java.util.List;

/**
 *
 * @author lucille
 */
public interface VirementDAO {
    public void save(VirementEntity c);
    public void update(VirementEntity c);
    public void delete(VirementEntity c);
    public VirementEntity find(long id);
    public List<VirementEntity> findAll();
    public List<VirementEntity> findFrom(long id);
    public List<VirementEntity> findTo(long id);
}
