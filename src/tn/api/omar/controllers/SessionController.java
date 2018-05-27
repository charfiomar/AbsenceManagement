package tn.api.omar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.api.omar.daos.SessionDAO;
import tn.api.omar.entities.Session;

@Controller
@RequestMapping("/session")
public class SessionController {

	private ArrayList<String> days = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
	{   add("Monday");
	    add("Tuesday");
	    add("Wednesday");
	    add("Thursday");
	    add("Friday");
	    add("Saturday");
	}};
	
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<Session> list = SessionDAO.listSessions();
		model.addObject("list", list);
		model.setViewName("session/list");
		return model;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		model.addObject("days", days);
		model.setViewName("session/add");
		return model;
	}

	@RequestMapping(value = { "/addItem" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("session") Session session, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/403";
		SessionDAO.addSession(session);
		return "redirect:/session/list";
	}

	@RequestMapping(value = { "/editItem" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("session") Session session, BindingResult result) {
		if (result.hasErrors())
			JOptionPane.showMessageDialog(null, result);
		SessionDAO.editSession(session);
		return "redirect:/session/list";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView();
		List<Session> list = SessionDAO.listSessions();
		for (Session item : list) {
			if (item.getSid().equals(id)) {
				model.addObject("item", item);
				break;
			}
		}
		model.addObject("days", days);
		model.setViewName("session/edit");
		return model;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Session s = new Session();
		s.setSid(id);
		SessionDAO.deleteSession(s);
		return "redirect:/session/list";
	}
}
