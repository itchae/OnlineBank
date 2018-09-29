/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucille
 */
@Controller
public class consultAccount {
    
    @RequestMapping(value="consultAccount", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        HttpSession session  = request.getSession(false);
        if(session==null){
            ModelAndView co = new ModelAndView();
            co.addObject("index");
            return co; 
        }else{
            ModelAndView pasCo = new ModelAndView();
            pasCo.addObject("consultAccount");
            return pasCo; 
        }
    }
    
    /*@RequestMapping(value="consultAccount", method = RequestMethod.GET)
    public ModelAndView initIndex(){
        ModelAndView pasCo = new ModelAndView("consultAccount");
        return pasCo; 
    }*/
    
    
    
  @RequestMapping(value = "consultAccount", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = null;
    HttpSession session = request.getSession(false);
    if(session == null){
        mav = new ModelAndView("error");
    }else{
        mav = new ModelAndView("consultAccount");
    }
    
    //mav.addObject("login", new Login());
    return mav;
  }
    
}
