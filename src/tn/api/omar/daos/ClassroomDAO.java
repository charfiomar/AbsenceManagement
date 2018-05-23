package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

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
}