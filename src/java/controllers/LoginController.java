/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import services.ConnectService;

/**
 *
 * @author lucille
 */
@Controller
public class LoginController {
    
    @Autowired
    private ConnectService service;
    
    @RequestMapping(value="home", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        ModelAndView mav = null;
        HttpSession session = request.getSession();
        String login;
        if (session.getAttribute("login") == null){
            login = request.getParameter("login");
            String mdp = request.getParameter("mdp");
            if(login.equals("toto") && mdp.equals("tata")){
                session.setAttribute("login", login);
            }
            else{
                return new ModelAndView("errorLogin");
            }
        }
        else{
            login = (String)session.getAttribute("login");
        }
        mav = new ModelAndView("listAccount");
        mav.addObject("welcome", service.welcome(login)); 
        return mav;
    }
    
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView initIndex(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = null;
    if(request.getSession(false).getAttribute("login") == null ){
        mav = new ModelAndView("login");
    }else{
        mav = new ModelAndView("listAccount");
    }
    return mav;
  }
    
    @RequestMapping(value="errorLogin", method = RequestMethod.GET)
    public ModelAndView errorLoginRedirect(){
        ModelAndView loginPage = new ModelAndView("login");
	return loginPage;
    }
    
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    protected ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        if (session != null ){
            session.setAttribute("login", null);
        }
        return new ModelAndView("logout");
        
    }

}
