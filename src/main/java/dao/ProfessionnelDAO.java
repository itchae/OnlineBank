/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.ProfessionnelEntity;
import entities.CompteEntity;
import java.util.List;

/**
 *
 * @author tbonnion
 */
public interface ProfessionnelDAO {
    public void save(CompteEntity c);
    public void update(ProfessionnelEntity c);
    public void delete(ProfessionnelEntity c);
    public ProfessionnelEntity find(String id);
    public List<ProfessionnelEntity> findAll();
    public List<ProfessionnelEntity> findByName(String nom);
}
