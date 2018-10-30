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
public interface VirementDAO {
    public void save(ProfessionnelEntity c);
    public void update(ProfessionnelEntity c);
    public void delete(ProfessionnelEntity c);
    public ProfessionnelEntity find(long id);
    public List<ProfessionnelEntity> findAll();
    public List<ProfessionnelEntity> findByName(String nom);
}
