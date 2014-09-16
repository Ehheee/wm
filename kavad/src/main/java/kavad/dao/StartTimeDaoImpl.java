package kavad.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kavad.dataobjects.StartTime;

@Component("startTimeDao")
public class StartTimeDaoImpl implements StartTimeDao {

	protected Log logger = LogFactory.getLog(getClass());
	public long save(StartTime startTime) {
		logger.info(startTime.getId());
		StartTime st = getById(startTime.getId());
		if(st != null){
			sessionFactory.getCurrentSession().merge(startTime);
			return startTime.getId();
		}else{
			return (Long) sessionFactory.getCurrentSession().save(startTime);
		}
	
	}

	public void delete(StartTime startTime) {
		sessionFactory.getCurrentSession().delete(startTime);

	}

	public StartTime getById(long id) {
		return (StartTime)sessionFactory.getCurrentSession().get(StartTime.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<StartTime> getByChannelBetweenDates(String channelName, Date min, Date max) {
		return sessionFactory.getCurrentSession().createCriteria(StartTime.class)
											.add(Restrictions.between("time", min, max))
											.add(Restrictions.eq("enabled", true))
											.addOrder(Order.asc("time"))
											.createCriteria("program")
												.add(Restrictions.eq("enabled", true))
												.createAlias("channel", "c")
												.add(Restrictions.eq("c.name", channelName))
											.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
												.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<StartTime> getByProgramBetweenDates(String programName, Date min, Date max){
		return sessionFactory.getCurrentSession().createCriteria(StartTime.class)
												.add(Restrictions.between("time", min, max))
												.add(Restrictions.eq("enabled", true))
												.addOrder(Order.asc("time"))
												.createCriteria("program")
													.add(Restrictions.eq("name", programName))
													.add(Restrictions.eq("enabled", true))
												.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
												.list();
	}
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see kavad.dao.StartTimeDao#getByTagBetweenDates(java.lang.String, java.util.Date, java.util.Date)
	 */
	
	@SuppressWarnings("unchecked")
	public List<StartTime> getByTagBetweenDates(String tagName, Date min, Date max){
		logger.info(tagName);
		logger.info(min);
		logger.info(max);
		return sessionFactory.getCurrentSession().createCriteria(StartTime.class)
												.add(Restrictions.between("time", min, max))
												.add(Restrictions.eq("enabled", true))
												.addOrder(Order.asc("time"))
												.createCriteria("program")
													.createCriteria("tags")
													.add(Restrictions.eq("name", tagName))
												.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
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
