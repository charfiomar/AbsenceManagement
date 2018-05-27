package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.api.omar.daos.ClassroomDAO;
import tn.api.omar.entities.Classroom;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<Classroom> list = ClassroomDAO.listClassrooms();
		model.addObject("list", list);
		model.setViewName("classroom/list");
		return model;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		model.setViewName("classroom/add");
		return model;
	}

	@RequestMapping(value = { "/addItem" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("classroom") Classroom classroom, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		ClassroomDAO.addClassroom(classroom);
		return "redirect:/classroom/list";
	}
	
	@RequestMapping(value = { "/editItem" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("classroom") Classroom classroom, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		ClassroomDAO.editClassroom(classroom);
		return "redirect:/classroom/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		List<Classroom> list = ClassroomDAO.listClassrooms();
		for (Classroom item : list) {
			if (item.getCrid().equals(id)) {
				model.addObject("item", item);
				break;
			}
		}
		model.setViewName("classroom/edit");
		return model;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Classroom c = new Classroom(id);
		ClassroomDAO.deleteClassroom(c);
		return "redirect:/classroom/list";
	}
}
