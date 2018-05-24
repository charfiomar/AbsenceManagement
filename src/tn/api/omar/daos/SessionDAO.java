package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import tn.api.omar.entities.Session;
import tn.api.omar.utils.HibernateUtils;

public class SessionDAO {

	@SuppressWarnings("unchecked")
	public static List<Session> listSessions() {
		List<Session> list = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from Session");
			list = (List<Session>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		} finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}

	public static void addSession(Session obj) {
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

	public static void editSession(Session obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			Session sess = (Session) HibernateUtils.session.get().load(Session.class, new Integer(obj.getSid()));
			sess.setDay(obj.getDay());
			sess.setStartTime(obj.getStartTime());
			sess.setEndTime(obj.getEndTime());
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

	public static void deleteSession(Session obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			Session sess = (Session) HibernateUtils.session.get().load(Session.class, new Integer(obj.getSid()));
			HibernateUtils.session.get().delete(sess);
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
