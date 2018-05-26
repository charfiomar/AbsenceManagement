package tn.api.omar.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
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
