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
import services.BanquierService;
import services.CompteService;
import services.ParticulierService;
import services.ProfessionelService;

/**
 *
 * @author lucille
 */
@Controller
public class parameterController {
    @Autowired
    ParticulierService part;
    
    @Autowired
    BanquierService banq;
    
    @Autowired
    ProfessionelService pro;
    
    @Autowired
    CompteService compt;
    
    @RequestMapping(value="parameter", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session = request.getSession(false);
        String res = (String)session.getAttribute("role");
        String id = (String)session.getAttribute("login");
        if (res.equals("par")){
            if(!request.getParameter("mail").equals("")){
                part.setEmail(id, request.getParameter("mail"));
            }
            if(!request.getParameter("address").equals("")){
                part.setAdresse(id, request.getParameter("address"));
            }
            if(!request.getParameter("phone").equals("")){
                part.setPhone(id, request.getParameter("phone"));
            }
            if(!request.getParameter("mdpchange").equals("")){
                part.setMdp(id, request.getParameter("mdpchange"));
            }
            if(!request.getParameter("prenom").equals("")){
                part.setPrenom(id, request.getParameter("prenom"));
            }
        }
        if (res.equals("banq")){
            if(!request.getParameter("mail").equals("")){
                banq.setEmail(id, request.getParameter("mail"));
            }
            if(!request.getParameter("address").equals("")){
                banq.setAdresse(id, request.getParameter("address"));
            }
            if(!request.getParameter("phone").equals("")){
                banq.setPhone(id, request.getParameter("phone"));
            }
            if(!request.getParameter("mdpchange").equals("") && request.getParameter("mdpchange").equals(request.getParameter("mdpconf"))){
                banq.setMdp(id, request.getParameter("mdpchange"));
            }
            if(!request.getParameter("prenom").equals("")){
                banq.setPrenom(id, request.getParameter("prenom"));
            }
        }
        if (res.equals("pro")){
            if(!request.getParameter("mail").equals("")){
                pro.setEmail(id, request.getParameter("mail"));
            }
            if(!request.getParameter("address").equals("")){
                pro.setAdresse(id, request.getParameter("address"));
            }
            if(!request.getParameter("phone").equals("")){
                pro.setPhone(id, request.getParameter("phone"));
            }
            if(!request.getParameter("mdpchange").equals("") && request.getParameter("mdpchange").equals(request.getParameter("mdpconf"))){
                pro.setMdp(id, request.getParameter("mdpchange"));
            }
            if(!request.getParameter("siret").equals("")){
                pro.setSiret(id, request.getParameter("prenom"));
            }
        }
        
        ModelAndView mv = new ModelAndView("success-parameter");
        return mv;
    }
    
    @RequestMapping(value="parameter", method = RequestMethod.GET)
    protected ModelAndView affiche(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session = request.getSession(false);
        String res = (String)session.getAttribute("role");
        String id = (String)session.getAttribute("login");
        ModelAndView mv = new ModelAndView("parameter");
        if (res.equals("par")){
            String login = part.getLogin(id);
            String email = part.getEmail(id);
            String adresse = part.getAdresse(id);
            String phone = part.getPhone(id);
            String mdp = part.getMdp(id);
            String prenom = part.getPrenom(id);
            //request.getSession();
            mv.addObject("email", email);
            mv.addObject("adresse", adresse);
            mv.addObject("phone", phone);
            mv.addObject("pwd", mdp);
            mv.addObject("logingars", login);
            mv.addObject("prenom",prenom);
        }
        if(res.equals("pro")){
            String login = pro.getLogin(id);
            String email = pro.getEmail(id);
            String adresse = pro.getAdresse(id);
            String phone = pro.getPhone(id);
            String mdp = pro.getMdp(id);
            String siret = pro.getSiret(id);
            mv.addObject("email", email);
            mv.addObject("adresse", adresse);
            mv.addObject("phone", phone);
            mv.addObject("pwd", mdp);
            mv.addObject("logingars", login);
            mv.addObject("siret",siret);
        }
        if(res.equals("banq")){
            String login = banq.getLogin(id);
            String email = banq.getEmail(id);
            String adresse = banq.getAdresse(id);
            String phone = banq.getPhone(id);
            String mdp = banq.getMdp(id);
            String prenom = banq.getPrenom(id);
            mv.addObject("email", email);
            mv.addObject("adresse", adresse);
            mv.addObject("phone", phone);
            mv.addObject("pwd", mdp);
            mv.addObject("logingars", login);
            mv.addObject("prenom", prenom);
        }
        return mv;
    }
}
