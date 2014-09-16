package kavad.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kavad.dataobjects.Channel;

@Component
public class ChannelDaoImpl implements ChannelDao {

	public long save(Channel channel){
		Channel c = getById(channel.getId());
		if(c != null){
			sessionFactory.getCurrentSession().merge(channel);
			return channel.getId();
		}else{
			long id = (Long) sessionFactory.getCurrentSession().save(channel);
			return id;
		}
	}
	
	public void delete(long id){
		Channel c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

	public Channel getById(long id) {
		return (Channel) sessionFactory.getCurrentSession().get(Channel.class, id);
	}
	
	public Channel getByName(String channelName){
		return (Channel) sessionFactory.getCurrentSession()
										.createQuery("from Channel where name = ?")
										.setString(0, channelName)
										.uniqueResult();
	}
	
	public List<Channel> getAll(){
		return sessionFactory.getCurrentSession().createQuery("from Channel").list();
	}
	
	
	
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
