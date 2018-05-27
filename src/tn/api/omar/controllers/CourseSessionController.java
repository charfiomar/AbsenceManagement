package tn.api.omar.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.api.omar.daos.ClassroomDAO;
import tn.api.omar.daos.CourseSessionDAO;
import tn.api.omar.daos.GroupDAO;
import tn.api.omar.daos.ProfessorDAO;
import tn.api.omar.daos.SessionDAO;
import tn.api.omar.daos.SubjectDAO;
import tn.api.omar.entities.Classroom;
import tn.api.omar.entities.CourseSession;
import tn.api.omar.entities.Groups;
import tn.api.omar.entities.Professor;
import tn.api.omar.entities.Session;
import tn.api.omar.entities.Subject;
import tn.api.omar.entities.embeddable.CourseSessionEmbeddedPK;

@Controller
@RequestMapping("/courseSession")
public class CourseSessionController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<CourseSession> list = CourseSessionDAO.listCourseSessions();
		model.addObject("list", list);
		model.setViewName("courseSession/list");
		return model;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		List<Professor> profs = ProfessorDAO.listProfessors();
		model.addObject("profs", profs);
		List<Groups> grps = GroupDAO.listGroups();
		model.addObject("grps", grps);
		List<Classroom> crms = ClassroomDAO.listClassrooms();
		model.addObject("crms", crms);
		List<Session> sess = SessionDAO.listSessions();
		model.addObject("sess", sess);
		List<Subject> subs = SubjectDAO.listSubjects();
		model.addObject("subs", subs);
		model.setViewName("courseSession/add");
		return model;
	}

	@RequestMapping(value = { "/addItem" }, method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {
		CourseSessionEmbeddedPK csPk = new CourseSessionEmbeddedPK();
		csPk.setPid(Integer.parseInt(request.getParameter("pid")));
		csPk.setCrid(Integer.parseInt(request.getParameter("crid")));
		csPk.setGid(Integer.parseInt(request.getParameter("gid")));
		csPk.setSid(Integer.parseInt(request.getParameter("sid")));
		CourseSession courseSession = new CourseSession(csPk, Integer.parseInt(request.getParameter("subid")));
		if (!CourseSessionDAO.addCourseSession(courseSession)) {
			model.addAttribute("exception","true");
			return "redirect:/courseSession/list";
		}
		return "redirect:/courseSession/list";
	}

	@RequestMapping(value = { "/editItem" }, method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model) {
		CourseSessionEmbeddedPK csPk = new CourseSessionEmbeddedPK();
		csPk.setPid(Integer.parseInt(request.getParameter("pid")));
		csPk.setCrid(Integer.parseInt(request.getParameter("crid")));
		csPk.setGid(Integer.parseInt(request.getParameter("gid")));
		csPk.setSid(Integer.parseInt(request.getParameter("sid")));
		CourseSession courseSession = new CourseSession(csPk, Integer.parseInt(request.getParameter("subid")));
		if (!CourseSessionDAO.editCourseSession(courseSession)) {
			model.addAttribute("exception","true");
			return "redirect:/courseSession/list";
		}
		return "redirect:/courseSession/list";
	}

	@RequestMapping(value = { "/edit/{pid}/{gid}/{crid}/{sid}" }, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("pid") Integer pid, @PathVariable("gid") Integer gid,
			@PathVariable("crid") Integer crid, @PathVariable("sid") Integer sid) {
		ModelAndView model = new ModelAndView();
		List<CourseSession> list = CourseSessionDAO.listCourseSessions();
		for (CourseSession item : list) {
			CourseSessionEmbeddedPK csid = item.getCsid();
			if (csid.getGid().equals(gid) && csid.getCrid().equals(crid) && csid.getPid().equals(pid)
					&& csid.getSid().equals(sid)) {
				model.addObject("item", item);
				break;
			}
		}
		List<Professor> profs = ProfessorDAO.listProfessors();
		model.addObject("profs", profs);
		List<Groups> grps = GroupDAO.listGroups();
		model.addObject("grps", grps);
		List<Classroom> crms = ClassroomDAO.listClassrooms();
		model.addObject("crms", crms);
		List<Session> sess = SessionDAO.listSessions();
		model.addObject("sess", sess);
		List<Subject> subs = SubjectDAO.listSubjects();
		model.addObject("subs", subs);
		model.setViewName("courseSession/edit");
		return model;
	}

	@RequestMapping(value = { "/delete/{pid}/{gid}/{crid}/{sid}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("pid") Integer pid, @PathVariable("gid") Integer gid,
			@PathVariable("crid") Integer crid, @PathVariable("sid") Integer sid) {
		CourseSession cs = new CourseSession(pid, gid, crid, sid, -1);
		CourseSessionDAO.deleteCourseSession(cs);
		return "redirect:/courseSession/list";
	}
}
