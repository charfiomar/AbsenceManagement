package tn.api.omar.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import tn.api.omar.config.HibernateUtils;
import tn.api.omar.entities.Professor;

public class ProfessorDAO {

	@SuppressWarnings("unchecked")
	public static List<Professor> listProfessors(){
		List<Professor> list = null;
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			Query query = HibernateUtils.session.get().createQuery("from Professor");
			list = (List<Professor>) query.list();
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<>();
		}finally {
			HibernateUtils.session.get().close();
		}
		return list;
	}
	
	public static Professor listProfessor(Integer id){
		Professor p = null;
		try{
			HibernateUtils.session.set(HibernateUtils.SESSION_FACTORY.openSession());
			p = (Professor) HibernateUtils.session.get().get(Professor.class, id);
		}catch(Exception e){
			e.printStackTrace();
			return new Professor();
		}finally {
			HibernateUtils.session.get().close();
		}
		return p;
	}
}
