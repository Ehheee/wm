package kavad.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kavad.dataobjects.Program;

@Component("programDao")
public class ProgramDaoImpl implements ProgramDao {

	public long save(Program program) {
		Program p = getById(program.getId());
		if(p != null){
			sessionFactory.getCurrentSession().merge(program);
			return program.getId();
		}else{
			return (Long) sessionFactory.getCurrentSession().save(program);
		}

	}
	
	public void delete(long id){
		Program p = getById(id);
		sessionFactory.getCurrentSession().delete(p);
	}

	public Program getById(long id) {
		return (Program) sessionFactory.getCurrentSession().get(Program.class, id);
	}

	public Program getByName(String name) {
		return (Program) sessionFactory.getCurrentSession()
										.createQuery("from Program where name = ?")
										.setString(0, name)
										.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Program> getAll() {
		return sessionFactory.getCurrentSession()
								.createQuery("from Program")
								.list();
	}


	
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
