package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.entities.Groups;

public class GroupDAO {

	@SuppressWarnings("unchecked")
	public static List<Groups> listGroups() {
		List<Groups> list = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			HibernateUtils.session.get().beginTransaction();
			Query query = HibernateUtils.session.get().createQuery("from Groups");
			list = (List<Groups>) query.list();
			HibernateUtils.session.get().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		return list;
	}

	public static void addGroups(Groups obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			t = HibernateUtils.session.get().beginTransaction();
			HibernateUtils.session.get().save(obj);
			HibernateUtils.session.get().flush();
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}

	public static void editGroups(Groups obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			t = HibernateUtils.session.get().beginTransaction();
			Groups grp = (Groups) HibernateUtils.session.get().load(Groups.class, new Integer(obj.getGid()));
			grp.setGnumber(obj.getGnumber());
			grp.setGyear(obj.getGyear());
			grp.setGmail(obj.getGmail());
			grp.setSpid(obj.getSpid());
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}

	public static void deleteGroups(Groups obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			t = HibernateUtils.session.get().beginTransaction();
			Groups grp = (Groups) HibernateUtils.session.get().load(Groups.class, new Integer(obj.getGid()));
			HibernateUtils.session.get().delete(grp);
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}

}
