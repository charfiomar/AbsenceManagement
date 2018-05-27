package tn.api.omar.test;

import tn.api.omar.util.FullCalendarEventInitializer;

public class Test {

	public static void main(String[] args) {
		// SubjectDAO.addSubject(new Subject("CLOUD"));
		// ClassroomDAO.addClassroom(new Classroom("SC4"));
		// ClassroomDAO.editClassroom(new Classroom(1,"SC11"));
		// ClassroomDAO.editClassroom(new Classroom(3,"SC3"));
		// ClassroomDAO.deleteClassroom(new Classroom(5,"SC4"));

		// GroupDAO.deleteGroups(new Groups(4,3,3,"test@institut.com",2));
		// SpecialityDAO.deleteSpeciality(new Speciality(3,"AArchitecture"));
		// SessionDAO.addSession(new Session(new Time(8,30,0),new
		// Time(8,30,0),"Tuesday"));
		// CourseSessionDAO.addCourseSession(new CourseSession(1, 1, 1, 1, 1));
		System.out.println(FullCalendarEventInitializer.buildCalendarEvents());
	}

}
