package kavad.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kavad.dataobjects.KavadUser;

@Component(value = "kavadUserDao")
public class KavadUserDaoImpl implements KavadUserDao {

	public KavadUser getById(long id) {
		return (KavadUser) sessionFactory.getCurrentSession().get(KavadUser.class, id);
	}

	public List<KavadUser> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from KavadUser").list();
	}
	
	public KavadUser getByName(String name){
		return (KavadUser) sessionFactory.
							getCurrentSession()
							.createQuery("from KavadUser where userName = ?")
							.setString(0, name)
							.uniqueResult();
	}
	
	public void save(KavadUser kavadUser){
		KavadUser ku = getById(kavadUser.getId());
		if(ku != null){
			sessionFactory.getCurrentSession().merge(kavadUser);
		}else{
			sessionFactory.getCurrentSession().save(kavadUser);
		}
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
