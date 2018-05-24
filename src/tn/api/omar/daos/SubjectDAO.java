package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.entities.Subject;

public class SubjectDAO {

	
	@SuppressWarnings("unchecked")
	public static List<Subject> listSubjects(){
		List<Subject> list = null;
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from Subject");
			list = (List<Subject>) query.list();
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<>();
		}finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}
}
