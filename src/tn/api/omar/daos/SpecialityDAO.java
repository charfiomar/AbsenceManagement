package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import tn.api.omar.entities.Speciality;
import tn.api.omar.utils.HibernateUtils;

public class SpecialityDAO {

	@SuppressWarnings("unchecked")
	public static List<Speciality> listSpecialities() {
		List<Speciality> list = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from Speciality");
			list = (List<Speciality>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		} finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}

	public static void addSpeciality(Speciality obj) {
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

	public static void editSpeciality(Speciality obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			Speciality spec = (Speciality) HibernateUtils.session.get().load(Speciality.class,
					new Integer(obj.getSpid()));
			spec.setSpname(obj.getSpname());

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

	public static void deleteSpeciality(Speciality obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			t = HibernateUtils.session.get().beginTransaction();
			Speciality spec = (Speciality) HibernateUtils.session.get().load(Speciality.class, new Integer(obj.getSpid()));
			HibernateUtils.session.get().delete(spec);
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
