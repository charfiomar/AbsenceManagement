package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		ModelAndView model = new ModelAndView();
		model.setViewName("professor/add");
		return model;
	}

	@RequestMapping(value = { "/addItem" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("professor") Professor professor, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		ProfessorDAO.addProfessor(professor);
		return "redirect:/professor/list";
	}

	@RequestMapping(value = { "/editItem" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("professor") Professor professor, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		ProfessorDAO.editProfessor(professor);
		return "redirect:/professor/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		List<Professor> list = ProfessorDAO.listProfessors();
		for (Professor item : list) {
			if (item.getPid().equals(id)) {
				model.addObject("item", item);
				break;
			}
		}
		model.setViewName("professor/edit");
		return model;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Professor p = new Professor();
		p.setPid(id);
		ProfessorDAO.deleteProfessor(p);
		return "redirect:/professor/list";
	}
}
