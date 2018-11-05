/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.VirementEntity;
import java.util.List;
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
public class consultAccount {
    
    @Autowired
    ParticulierService particulierService;
    
    @Autowired
    CompteService c;
    
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
    String idCompte = request.getParameter("param");
    if(session == null){
        mav = new ModelAndView("error");
    }else{
        mav = new ModelAndView("consultAccount");
    }
    Long id = (Long)Long.parseLong(idCompte);
    List<VirementEntity> virementsFrom = c.getFrom(id);
    List<VirementEntity> virementsTo = c.getTo(id);
    String printFrom = c.printFrom(id);
    String printTo = c.printTo(id);
    mav.addObject("from", virementsFrom);
    mav.addObject("to", virementsTo);
    mav.addObject("printFrom", printFrom);
    mav.addObject("printTo", printTo);
    return mav;
  }
    
}
