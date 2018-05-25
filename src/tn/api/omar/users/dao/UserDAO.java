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
			System.out.println("HERE");
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			users = HibernateUtils.session
					.get()
					.createQuery("from User where username=?")
					.setParameter(0, username)
					.list();
			System.out.println(users + " HERER");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(HibernateUtils.session.get().isOpen())
				HibernateUtils.session.get().close();
		}

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}