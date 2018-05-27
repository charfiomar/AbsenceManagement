package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		ModelAndView model = new ModelAndView();
		model.setViewName("speciality/add");
		return model;
	}

	@RequestMapping(value = { "/addItem" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("speciality") Speciality speciality, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		SpecialityDAO.addSpeciality(speciality);
		return "redirect:/speciality/list";
	}

	@RequestMapping(value = { "/editItem" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("speciality") Speciality speciality, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		SpecialityDAO.editSpeciality(speciality);
		return "redirect:/speciality/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		List<Speciality> list = SpecialityDAO.listSpecialities();
		for (Speciality item : list) {
			if (item.getSpid().equals(id)) {
				model.addObject("item", item);
				break;
			}
		}
		model.setViewName("speciality/edit");
		return model;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Speciality s = new Speciality();
		s.setSpid(id);
		SpecialityDAO.deleteSpeciality(s);
		return "redirect:/speciality/list";
	}
}
