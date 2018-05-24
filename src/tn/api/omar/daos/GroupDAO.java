package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.entities.Groups;

public class GroupDAO {

	@SuppressWarnings("unchecked")
	public static List<Groups> listGroups(){
		List<Groups> list = null;
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from Groups");
			list = (List<Groups>) query.list();
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<>();
		}finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}
}
