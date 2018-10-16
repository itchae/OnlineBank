/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.service;


import com.univpoitiers.fr.animalkeepermaven.dao.AnimalDao;
import com.univpoitiers.fr.animalkeepermaven.dao.AnimalEntity;
import com.univpoitiers.fr.animalkeepermaven.dao.KeeperDao;
import com.univpoitiers.fr.animalkeepermaven.dao.KeeperEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edarles
 */
@Service
public class KeeperServiceImpl implements KeeperService {

    @Autowired
    KeeperDao keeperDao;
    
    @Autowired
    AnimalDao animalDao;
    
    @Override
    public boolean add(String nom, String prenom, String age, String adresse) {
        if(keeperDao.find(nom)==null){
            KeeperEntity k = new KeeperEntity(nom,prenom,age,adresse);
            keeperDao.save(k);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String nom) {
        KeeperEntity k = keeperDao.find(nom);
        if(k!=null){
            keeperDao.delete(k);
            return true;
        }
        return false;
    }

    @Override
    public KeeperEntity find(String nom) {
        return keeperDao.find(nom);
    }
    
    @Override
    public void addAnimal(String nomKeeper, String nomAnimal)
    {
      KeeperEntity k = keeperDao.find(nomKeeper);
      AnimalEntity a = animalDao.find(nomAnimal);
      keeperDao.addAnimal(k, a);
    }
     
    @Override
    public String printKeepers()
    {
        List<KeeperEntity> keepers = keeperDao.findAll();
        String result="";
        for(int i=0;i<keepers.size();i++)
            result += "<P> "+keepers.get(i).toString()+"</P>";
        return result;
    }
    
    @Override
    public String printAnimals(String nomKeeper)
    {
        String result = "";
        KeeperEntity keeper = keeperDao.find(nomKeeper);
        result += "<h2><P> "+ keeper.toString()+"</P></h2>";
        List<AnimalEntity> animals = keeper.getAnimals();
        result += "<P> Animals </P>";
        for(int j=0;j<animals.size();j++)
                result += "<P>"+animals.get(j).toString()+"</P>";
        return result;
    }
}
