package kavad.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kavad.dataobjects.Tag;

@Component("tagDao")
public class TagDaoImpl implements TagDao {

	public void save(Tag tag) {
		Tag t = getByName(tag.getName());
		if(t != null){
			sessionFactory.getCurrentSession().merge(tag);
		}else{
			sessionFactory.getCurrentSession().save(tag);
		}
	}

	public Tag getById(long id) {
		return (Tag)sessionFactory.getCurrentSession().get(Tag.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tag> getAll(){
		return sessionFactory.getCurrentSession().createQuery("from Tag").list();
	}

	public Tag getByName(String name) {
		return (Tag)sessionFactory.getCurrentSession()
									.createQuery("from Tag where name = ?")
									.setString(0, name)
									.uniqueResult();
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
