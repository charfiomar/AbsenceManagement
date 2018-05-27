package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.api.omar.daos.GroupDAO;
import tn.api.omar.daos.SpecialityDAO;
import tn.api.omar.entities.Groups;
import tn.api.omar.entities.Speciality;

@Controller
@RequestMapping("/groups")
public class GroupController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<Groups> list = GroupDAO.listGroups();
		List<Speciality> list1 = SpecialityDAO.listSpecialities();
		for (Groups g : list) {
			for (Speciality s : list1) {
				if (g.getSpid().equals(s.getSpid())) {
					model.addObject("gspname" + g.getGid(), s.getSpname());
					break;
				}
			}
		}
		model.addObject("list", list);
		return model;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		List<Speciality> specs = SpecialityDAO.listSpecialities();
		model.addObject("specs", specs);
		model.setViewName("groups/add");
		return model;
	}

	@RequestMapping(value = { "/addItem" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("groups") Groups groups, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		GroupDAO.addGroups(groups);
		return "redirect:/groups/list";
	}

	@RequestMapping(value = { "/editItem" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("groups") Groups groups, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		GroupDAO.editGroups(groups);
		return "redirect:/groups/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		List<Speciality> specs = SpecialityDAO.listSpecialities();
		List<Groups> list = GroupDAO.listGroups();
		for (Groups item : list) {
			if (item.getGid().equals(id)) {
				model.addObject("item", item);
				break;
			}
		}
		model.addObject("specs", specs);
		model.setViewName("groups/edit");
		return model;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Groups g = new Groups();
		g.setGid(id);
		GroupDAO.deleteGroups(g);
		return "redirect:/groups/list";
	}
}
