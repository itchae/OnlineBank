/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.service;


import com.univpoitiers.fr.animalkeepermaven.dao.AnimalDao;
import com.univpoitiers.fr.animalkeepermaven.dao.AnimalEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edarles
 */
@Service
public class AnimalServiceImpl implements AnimalService {
    
   // @Resource
    @Autowired
    AnimalDao animalDao;
    
    @Override
    public boolean add(String nom, String age, String type)
    {
        if(animalDao.find(nom)==null){
            AnimalEntity a = new AnimalEntity(nom,age,type);
            animalDao.save(a);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean remove(String nom)
    {
        AnimalEntity a = animalDao.find(nom);
        if(a!=null){
            animalDao.delete(a);
            return true;
        }
        return false;
    }
   
    @Override
    public AnimalEntity find(String nom)
    {
        return (animalDao.find(nom));
    }
    
    @Override
    public String printAnimals()
    {
        List<AnimalEntity> animals = animalDao.findAll();
        String result="";
        for(int i=0;i<animals.size();i++)
            result += "<P> "+animals.get(i).toString()+"</P>";
        return result;
    }
}
