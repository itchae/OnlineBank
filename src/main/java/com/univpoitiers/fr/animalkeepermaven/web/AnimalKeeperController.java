/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.animalkeepermaven.web;

import com.univpoitiers.fr.animalkeepermaven.service.AnimalService;
import com.univpoitiers.fr.animalkeepermaven.service.KeeperService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author edarles
 */
@Controller
public class AnimalKeeperController {
    
    @Autowired
    AnimalService animalService;
    
    @Autowired
    KeeperService keeperService;
  
    @RequestMapping(value="accueil", method=RequestMethod.GET)
    String initAccueil()
    {
        return "accueil";
    }
    
  
    @RequestMapping(value="add", method=RequestMethod.GET)
    String initAdd()
    {
        return "add";
    }
   
    @RequestMapping(value="addAnimal", method=RequestMethod.GET)
    String initAddAnimal()
    {
        return "addAnimal";
    }
    
    @RequestMapping (value="addAnimal", method=RequestMethod.POST)
    protected ModelAndView handleAnimal(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
            String nom = request.getParameter("nom");
            String age = request.getParameter("age");
            String type = request.getParameter("type");
            
            ModelAndView mv = new ModelAndView("add");
                
            boolean result = animalService.add(nom,age,type);
            if(result)
                mv.addObject("indexMessage","Animal ajouté avec succès.");
            else
                mv.addObject("indexMessage","Erreur: Animal non ajouté");
            mv.addObject("listeMessage",animalService.printAnimals());
            return mv;
    }
    
    @RequestMapping(value="addKeeper", method=RequestMethod.GET)
    String initAddKeeper()
    {
        return "addKeeper";
    }
    
    @RequestMapping (value="addKeeper", method=RequestMethod.POST)
    protected ModelAndView handleKeeper(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String age = request.getParameter("age");
            String adresse = request.getParameter("adresse");
            
            ModelAndView mv = new ModelAndView("add");
            boolean result = keeperService.add(nom,prenom,age,adresse);
            if(result)
                mv.addObject("indexMessage","Keeper ajouté avec succès.");
            else
                mv.addObject("indexMessage","Erreur: Keeper non ajouté");
            mv.addObject("listeMessage", keeperService.printKeepers());
            return mv;
    }
    
    @RequestMapping(value="addKeeperAnimal", method=RequestMethod.GET)
    String initAddKeeperAnimal()
    {
        return "addKeeperAnimal";
    }
    
    @RequestMapping (value="addKeeperAnimal", method=RequestMethod.POST)
    protected ModelAndView handleKeeperAnimal(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
            String nomAnimal = request.getParameter("nomAnimal");
            String nomKeeper = request.getParameter("nomKeeper");
           
            ModelAndView mv = new ModelAndView("add");
            keeperService.addAnimal(nomKeeper, nomAnimal);
            String listeAnimal = keeperService.printAnimals(nomKeeper);
            mv.addObject("indexMessage","Keeper ajouté avec succès.");
            mv.addObject("listeMessage", listeAnimal);
            return mv;
    }
    
    @RequestMapping(value="affichage", method=RequestMethod.GET)
    String initAffichage()
    {
        return "accueil";
    }
    
    @RequestMapping (value="affichage", method=RequestMethod.POST)
    protected ModelAndView handleAffichage(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
           
        ModelAndView mv = new ModelAndView("display");
        String listeAnimals = animalService.printAnimals();
        String listeKeepers = keeperService.printKeepers();

        mv.addObject("listeAnimals", listeAnimals);
        mv.addObject("listeKeepers", listeKeepers);
        return mv;
    }
}
