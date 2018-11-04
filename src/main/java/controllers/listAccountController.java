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
public class listAccountController {
    
    @Autowired
    ParticulierService part;
    
    @Autowired
    CompteService ba;
    
    @RequestMapping(value="listAccount", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session  = request.getSession(false);
        ModelAndView mv = new ModelAndView();
        String login = (String)session.getAttribute("login");
        String list = ba.printAccount(login);
        //String listeComptes;
        //String listeComptes = part.printComptes();
        //listeComptes = ba.printAccount((Long)session.getAttribute("id"))
                //String listeComptes = part.printComptes();
        
        if(session==null){
            mv.addObject("index");
        }else{
            mv.addObject("listeComptes", list);
        }
        return mv;
    }
    
    @RequestMapping(value="listAccount", method = RequestMethod.GET)
    public ModelAndView initIndex(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String login = (String)session.getAttribute("login");
        String list = ba.printAccount(login);
	ModelAndView mv = new ModelAndView("listAccount");
        mv.addObject("idwtf", login);
        mv.addObject("listeComptes", list);
        return mv; 
    }



    
}
