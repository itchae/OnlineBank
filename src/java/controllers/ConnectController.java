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
 * @author edarles
 */
@Controller
public class ConnectController {
    
    @Autowired
    private ConnectService service;
    
    @RequestMapping(value="connect", method = RequestMethod.GET)
    public String initConnect(){
	return "connect";
    }
    @RequestMapping(value="connect", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session = request.getSession(false);
        if (session == null){
            ModelAndView mv = new ModelAndView("connect");
            ModelAndView error = new ModelAndView("index");
            String login = request.getParameter("login");
            String mdp = request.getParameter("mdp");
            mv.addObject("welcome", service.welcome(login)); 
            if(login.equals("toto") && mdp.equals("tata")){
                session = request.getSession();
                return mv; 
            }
            return error;
            }
        else{
            return new ModelAndView("listAccount");
        }
    }
    
}