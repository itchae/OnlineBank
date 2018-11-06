/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.CompteService;
import services.TransferService;

/**
 *
 * @author lucille
 */
@Controller
public class transferController {
    @Autowired 
    TransferService t; 
    
    @Autowired
    CompteService c; 
    
    @RequestMapping(value="transfer", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        ModelAndView mv = new ModelAndView("transfer");
        HttpSession session = request.getSession();
        String intitule = request.getParameter("nom"); 
        String montant = request.getParameter("somme");
        String beneficieur = request.getParameter("beneficieur");
        String id = request.getParameter("debiteur");
        boolean resultat = t.ajoutTransfert(intitule, montant, beneficieur, id);
        String res = "";
        if(resultat){
            res = "Virement effectué";
        }else{
            res = "Virement échoué, veuilliez vérifier les informations saisies";
        }
        
        mv.addObject("resultat", res);
        return mv;
    }
    
    @RequestMapping(value="transfer", method = RequestMethod.GET)
    protected ModelAndView affiche(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session = request.getSession();
        String login = (String)session.getAttribute("login");
        ModelAndView mv = new ModelAndView("transfer");
        String liste = c.printListAccount(login);
        mv.addObject("listeCompte", liste);
        return mv;
    }
}
