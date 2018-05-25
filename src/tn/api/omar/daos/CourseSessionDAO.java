package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.entities.CourseSession;


import tn.api.omar.entities.embeddable.CourseSessionEmbeddedPK;


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
	public static void addCourseSession(CourseSession obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			HibernateUtils.session.get().save(obj);
			HibernateUtils.session.get().flush();
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			HibernateUtils.session.get().close();
		}
	}
	
	public static void editCourseSession(CourseSession obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			CourseSession crs = (CourseSession)HibernateUtils.session.get().load(CourseSession.class,(obj.getCsid()));
			crs.setSubid(obj.getSubid());
			CourseSessionEmbeddedPK crsPk = crs.getCsid();
			crsPk.setCrid(obj.getCsid().getCrid());
			crsPk.setGid(obj.getCsid().getGid());
			crsPk.setPid(obj.getCsid().getPid());
			crsPk.setSid(obj.getCsid().getSid());
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			HibernateUtils.session.get().close();
		}
	}
	public static void deleteCourseSession(CourseSession obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			CourseSession crs = (CourseSession)HibernateUtils.session.get().load(CourseSession.class,(obj.getCsid()));
			HibernateUtils.session.get().delete(crs);
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			HibernateUtils.session.get().close();
		}
	}
	
}
