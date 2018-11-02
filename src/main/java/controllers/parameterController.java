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
import services.ParticulierService;

/**
 *
 * @author lucille
 */
@Controller
public class parameterController {
    @Autowired
    ParticulierService part;
    
    @Autowired
    CompteService compt;
    
    @RequestMapping(value="parameter", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session = request.getSession(false);
        long id = (long)session.getAttribute("id");
        if(!request.getParameter("mail").equals("")){
            part.setEmail(id, request.getParameter("mail"));
        }
        if(!request.getParameter("address").equals("")){
            part.setAdresse(id, request.getParameter("address"));
        }
        if(!request.getParameter("phone").equals("")){
            part.setPhone(id, request.getParameter("phone"));
        }
        if(!request.getParameter("mdpchange").equals("") && request.getParameter("mdpchange").equals(request.getParameter("mdpconf"))){
            part.setMdp(id, request.getParameter("mdpchange"));
        }
        
        ModelAndView mv = new ModelAndView("parameter");
        String login = part.getLogin(id);
        String email = part.getEmail(id);
        String adresse = part.getAdresse(id);
        String phone = part.getPhone(id);
        String mdp = part.getMdp(id);
        //request.getSession();
        mv.addObject("email", email);
        mv.addObject("adresse", adresse);
        mv.addObject("phone", phone);
        mv.addObject("pwd", mdp);
        mv.addObject("logingars", login);
        return mv;
    }
    
    @RequestMapping(value="parameter", method = RequestMethod.GET)
    protected ModelAndView affiche(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session = request.getSession(false);
        String res = (String)session.getAttribute("role");
        long id = (long)session.getAttribute("id");
        ModelAndView mv = new ModelAndView("parameter");
        if (res.equals("par")){
            String login = part.getLogin(id);
            String email = part.getEmail(id);
            String adresse = part.getAdresse(id);
            String phone = part.getPhone(id);
            String mdp = part.getMdp(id);
            //request.getSession();
            mv.addObject("email", email);
            mv.addObject("adresse", adresse);
            mv.addObject("phone", phone);
            mv.addObject("pwd", mdp);
            mv.addObject("logingars", login);
        }
        if(res.equals("pro")){
            ///
            ///
        }
        if(res.equals("banq")){
            ///
            ///
        }
        return mv;
    }
}
