/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucille
 */
@Controller
public class parameterController {
    @RequestMapping(value="parameter", method = RequestMethod.POST)
    protected ModelAndView handle(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        ModelAndView mv = new ModelAndView("parameter");
        return mv;
    }
    
    @RequestMapping(value="parameter", method = RequestMethod.GET)
    protected ModelAndView affiche(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        ModelAndView mv = new ModelAndView("parameter");
        return mv;
    }
}
