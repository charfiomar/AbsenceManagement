package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.api.omar.daos.ProfessorDAO;
import tn.api.omar.entities.Professor;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<Professor> list = ProfessorDAO.listProfessors();
		model.addObject("list", list);
		model.setViewName("professor/list");
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
