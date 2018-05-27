package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.api.omar.daos.SubjectDAO;
import tn.api.omar.entities.Subject;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<Subject> list = SubjectDAO.listSubjects();
		model.addObject("list", list);
		model.setViewName("subject/list");
		return model;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		model.setViewName("subject/add");
		return model;
	}
	
	@RequestMapping(value = { "/addItem" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("subject") Subject subject, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		SubjectDAO.addSubject(subject);
		return "redirect:/subject/list";
	}
	
	@RequestMapping(value = { "/editItem" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("subject") Subject subject, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		SubjectDAO.editSubject(subject);
		return "redirect:/subject/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		List<Subject> list = SubjectDAO.listSubjects();
		for (Subject item : list) {
			if (item.getSubid().equals(id)) {
				model.addObject("item", item);
				break;
			}
		}
		model.setViewName("subject/edit");
		return model;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Subject s = new Subject();
		s.setSubid(id);
		SubjectDAO.deleteSubject(s);
		return "redirect:/subject/list";
	}
}
