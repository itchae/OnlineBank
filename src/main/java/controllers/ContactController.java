/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.BanquierService;
import services.ParticulierService;

/**
 *
 * @author tbonnion
 */

@Controller
public class ContactController {
    @Autowired
    ParticulierService ps;
    
    @Autowired
    BanquierService bs;
    
    @RequestMapping(value="contact", method=RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("login");
        String banquier = ps.getBanquier(id);
        String mail = "";
        String tel = "";
        String prenom = "";
        String nom = "";
        if(banquier != null){
            prenom = bs.getPrenom(banquier);
            nom = bs.getNom(banquier);
            mail = bs.getEmail(banquier);
            tel = bs.getPhone(banquier);
        }
        
        ModelAndView mav = new ModelAndView("contact");
        mav.addObject("mail", mail);
        mav.addObject("tel", tel);
        mav.addObject("nom", nom);
        mav.addObject("prenom", prenom);
        
        return mav;
    }
}
