package tn.api.omar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/session")
public class SessionController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		return null;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		return null;
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public ModelAndView edit() {
		return null;
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public ModelAndView delete() {
		return null;
	}
}
