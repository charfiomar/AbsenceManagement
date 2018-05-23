package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import tn.api.omar.entities.Speciality;
import tn.api.omar.utils.HibernateUtils;

public class SpecialityDAO {

	@SuppressWarnings("unchecked")
	public static List<Speciality> listSpecialities(){
		List<Speciality> list = null;
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from Speciality");
			list = (List<Speciality>) query.list();
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<>();
		}finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}
}
