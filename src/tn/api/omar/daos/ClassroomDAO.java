package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import tn.api.omar.entities.Classroom;
import tn.api.omar.utils.HibernateUtils;

public class ClassroomDAO {

	@SuppressWarnings("unchecked")
	public static List<Classroom> listClassrooms() {
		List<Classroom> list = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from Classroom");
			list = (List<Classroom>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		} finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}
	
	public static void addClassroom(Classroom obj) {
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
	
	public static void editClassroom(Classroom obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			Classroom cla = (Classroom)HibernateUtils.session.get().load(Classroom.class,new Integer(obj.getCrid()));
			cla.setCrname(obj.getCrname());
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
	public static void deleteSubject(Classroom obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			Classroom cla = (Classroom)HibernateUtils.session.get().load(Classroom.class,new Integer(obj.getCrid()));
			HibernateUtils.session.get().delete(cla);
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
