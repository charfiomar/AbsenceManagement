package tn.api.omar.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.users.model.User;

@Repository
public class UserDAO {

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			users = HibernateUtils.session
					.get()
					.createQuery("from Users where username=?")
					.setParameter(0, username)
					.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			HibernateUtils.session.get().close();
		}

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}