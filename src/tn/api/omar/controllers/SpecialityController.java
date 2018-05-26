package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.api.omar.daos.SpecialityDAO;
import tn.api.omar.entities.Speciality;

@Controller
@RequestMapping("/speciality")
public class SpecialityController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<Speciality> list = SpecialityDAO.listSpecialities();
		model.addObject("list", list);
		model.setViewName("speciality/list");
		return model;
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
