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
       
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        if(login.equals("toto") && mdp.equals("tata")){
            mav = new ModelAndView("listAccount");
        }else{
            mav = new ModelAndView("index");
        }
        return mav;
    }
    @RequestMapping(value="index", method = RequestMethod.GET)
    public ModelAndView initIndex(){
        ModelAndView index = new ModelAndView("index");
	return index;
    }

}
