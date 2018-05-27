package tn.api.omar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import tn.api.omar.daos.ClassroomDAO;
import tn.api.omar.daos.CourseSessionDAO;
import tn.api.omar.daos.GroupDAO;
import tn.api.omar.daos.ProfessorDAO;
import tn.api.omar.daos.SessionDAO;
import tn.api.omar.daos.SpecialityDAO;
import tn.api.omar.daos.SubjectDAO;
import tn.api.omar.entities.Classroom;
import tn.api.omar.entities.CourseSession;
import tn.api.omar.entities.Groups;
import tn.api.omar.entities.Professor;
import tn.api.omar.entities.Session;
import tn.api.omar.entities.Speciality;
import tn.api.omar.entities.Subject;

public class FullCalendarEventInitializer {

	private static SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat formatter2 = new SimpleDateFormat("EEEE");
	private static Random r = new Random();

	public static JSONArray buildCalendarEvents() {

		List<CourseSession> cSession = CourseSessionDAO.listCourseSessions();
		List<Session> sess = SessionDAO.listSessions();
		List<Subject> subj = SubjectDAO.listSubjects();
		List<Groups> grps = GroupDAO.listGroups();
		List<Classroom> croom = ClassroomDAO.listClassrooms();
		List<Speciality> specs = SpecialityDAO.listSpecialities();

		JSONArray array = new JSONArray();
		for (CourseSession cs : cSession) {
			Professor p = ProfessorDAO.listProfessor(cs.getCsid().getPid());
			String pname = p.getPfname() + " " + p.getPlname();
			Groups g = null;
			for (Groups gr : grps) {
				if (gr.getGid().equals(cs.getCsid().getGid())) {
					g = gr;
					break;
				}
			}
			String speciality = "";
			for (Speciality sp : specs) {
				if (sp.getSpid().equals(g.getSpid())) {
					speciality = sp.getSpname();
					break;
				}
			}
			speciality = g.getGyear() + "-" + speciality + "-G" + g.getGnumber();
			String subname = "";
			for (Subject sub : subj) {
				if (sub.getSubid().equals(cs.getSubid())) {
					subname = sub.getSubname();
					break;
				}
			}
			String classroom = "";
			for (Classroom crm : croom) {
				if (crm.getCrid().equals(cs.getCsid().getCrid())) {
					classroom = crm.getCrname();
				}
			}
			Session maSess = null;
			for (Session ses : sess) {
				if (ses.getSid().equals(cs.getCsid().getSid())) {
					maSess = ses;
					break;
				}
			}
			
			String hex = String.format("#%02x%02x%02x", r.nextInt(256), r.nextInt(256), r.nextInt(256)); 
			
			JSONObject obj = new JSONObject();

			Date next = nextWeekDay(maSess.getDay());

			String end = formatter1.format(next)+"T"+maSess.getEndTime();
			obj.put("end", end);

			String start = formatter1.format(next)+"T"+maSess.getStartTime();
			obj.put("start", start);

			String title = subname + " | " + speciality + " | " + pname + " | " + classroom;
			obj.put("title", title);

			obj.put("color", hex);
			array.put(obj);
		}
		return array;
	}

	public static Date nextWeekDay(String day) {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		while (!formatter2.format(today).equals(day)) {
			c.setTime(today);
			c.add(Calendar.DATE, 1);
			today = c.getTime();
		}
		return today;
	}
}
