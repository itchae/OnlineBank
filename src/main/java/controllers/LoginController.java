/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CompteEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
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
import services.ConnectService;
import services.InitService;
import services.ParticulierService;

/**
 *
 * @author lucille
 */
@Controller
public class LoginController {
    
    @Autowired
    ParticulierService particulierService;

    @Autowired 
    ConnectService coService;
    
    @Autowired
    InitService init;
    
    @Autowired
    CompteService ba;
    
    @Autowired
    BanquierService bq;
    
    boolean created=false;
    
    @RequestMapping(value="login", method=RequestMethod.GET)
    public ModelAndView init(){
        if (!created){
            init.InitService();
            created=true;
        }
        ModelAndView mav = new ModelAndView("login");
            return mav;
    }
    
    @RequestMapping(value="index", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        ModelAndView mav = null;
        HttpSession session = request.getSession();
        String login;
        String list = "";
        //String listeComptes = part.printComptes();
        long id = -1;
        
        if (session.getAttribute("login") == null){
            login = request.getParameter("login");
            String mdp = request.getParameter("mdp");
            
            id = coService.connection(login, mdp);
            if(id !=-1){
                session.setAttribute("login", login);
                session.setAttribute("id", id);
                String res = ba.compteRole(id);
                session.setAttribute("role", res); //ajout du role de l'utilisateur loggé
                list = ba.printAccount(id);
                //Ajouter l'id du compte ?? Pour savoir si c'est un particulier ou un pro
                //A partir du moment ou il est co il existe forcément, il faut juste savoir quel
                //type de compte c'est et donc quel affichage on fait 
            }else{
                return new ModelAndView("errorLogin");
            }
        }
        else{
            login = (String)session.getAttribute("login");
        }
        mav = new ModelAndView("listAccount");
        
        mav.addObject("welcome", coService.welcome(login));
        mav.addObject("listePart", particulierService.printComptes());
        mav.addObject("listeComptes", list);
        mav.addObject("idwtf", id);
        
        return mav;
    }
    
    /*@RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView initIndex(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = null;
    if(request.getSession(false).getAttribute("login") == null ){
        mav = new ModelAndView("login");
    }else{
        mav = new ModelAndView("listAccount");
    }
    return mav;
  }*/
    
    @RequestMapping(value="errorLogin", method = RequestMethod.GET)
    public String errorLoginRedirect(){
        return "login";
        //ModelAndView loginPage = new ModelAndView("login");
	//return loginPage;
    }
    
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    protected ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        if (session != null ){
            session.setAttribute("login", null);
        }
        return new ModelAndView("logout");
        
    }
    
    @RequestMapping(value = "affiche", method = RequestMethod.GET)
    protected ModelAndView affiche(){
        ModelAndView mv = new ModelAndView("display");
        String listeParticulier = particulierService.printComptes();
        mv.addObject("listePart", listeParticulier);
        return mv;
    }

}
