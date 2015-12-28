package com.ferrarib.gemStore.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ModelAndView redirectPage(ModelAndView modelAndView) throws ServletException, IOException {
//		RedirectView redirectView = new RedirectView("redirect: " + "/");
//		redirectView.setExposeModelAttributes(false);
//		
//		return new ModelAndView(redirectView);
//	}
}
