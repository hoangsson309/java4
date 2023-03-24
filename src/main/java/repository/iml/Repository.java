package repository.iml;

import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IRepository;
import util.HibernateUtil;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Repository<E> implements IRepository<E> {
	
	private Class<E> className;
	
	public Repository(Class<E> className) {
		this.className = className;
	}
	
	@Override
	public List<E> getAll() {
		List<E> list = new ArrayList<>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query =  session.createQuery("FROM " +className.getSimpleName());
			list = query.getResultList();
			return list;
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<E> resultListQuery(String hqlQuery) {
		List<E> list = new ArrayList<>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query _query_ =  session.createQuery(hqlQuery);
			list = _query_.getResultList();
			return list;
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return null;
	}
	
	@Override
	public E findByParameter(String parameter, String value) {
		E e = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query =  session.createQuery("FROM " +className.getSimpleName()
					+" WHERE " + parameter+"=:" + value);
			query.setParameter(value, value);
			e = (E)query.getSingleResult();
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return e;
	}
	
	@Override
	public boolean add(E e) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(e);
			transaction.commit();
			return true;
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean update(E e) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(e);
			transaction.commit();
			return true;
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean delete(E e) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(e);
			transaction.commit();
			return true;
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return false;
	}
}
