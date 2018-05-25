package tn.api.omar.users.dao;

import java.util.ArrayList;
import java.util.List;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.users.model.User;

public class UserDAO {

	@SuppressWarnings("unchecked")
	public static User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.getCurrentSession());
			HibernateUtils.session.get().beginTransaction();
			users = HibernateUtils.session
					.get()
					.createQuery("from User where username=?")
					.setParameter(0, username)
					.list();
			HibernateUtils.session.get().getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}