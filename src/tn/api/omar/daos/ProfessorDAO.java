package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.entities.Professor;

public class ProfessorDAO {

	@SuppressWarnings("unchecked")
	public static List<Professor> listProfessors() {
		List<Professor> list = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			HibernateUtils.session.get().beginTransaction();
			Query query = HibernateUtils.session.get().createQuery("from Professor");
			list = (List<Professor>) query.list();
			HibernateUtils.session.get().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		} finally {

		}
		return list;
	}

	public static Professor listProfessor(Integer id) {
		Professor p = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			HibernateUtils.session.get().beginTransaction();
			p = (Professor) HibernateUtils.session.get().get(Professor.class, id);
			HibernateUtils.session.get().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return new Professor();
		}
		return p;
	}

	public static void addProfessor(Professor obj) {
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

	public static void editProfessor(Professor obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			t = HibernateUtils.session.get().beginTransaction();
			Professor prof = (Professor) HibernateUtils.session.get().load(Professor.class, new Integer(obj.getPid()));
			prof.setPfname(obj.getPfname());
			prof.setPlname(obj.getPlname());
			prof.setPmail(obj.getPmail());
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}

	public static void deleteProfessor(Professor obj) {
		Transaction t = null;
		try {
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			t = HibernateUtils.session.get().beginTransaction();
			Professor prof = (Professor) HibernateUtils.session.get().load(Professor.class, new Integer(obj.getPid()));
			HibernateUtils.session.get().delete(prof);
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}
}
