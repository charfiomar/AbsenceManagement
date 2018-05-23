package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import tn.api.omar.entities.CourseSession;
import tn.api.omar.utils.HibernateUtils;

public class CourseSessionDAO {

	
	@SuppressWarnings("unchecked")
	public static List<CourseSession> listCourseSessions(){
		List<CourseSession> list = null;
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from CourseSession");
			list = (List<CourseSession>) query.list();
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<>();
		}finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}
}
