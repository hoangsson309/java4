package repository.iml;

import model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IRepository;
import util.HibernateUtil;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Repository<E> implements IRepository<E> {
	
	private Class<E> className;
	
	public Repository(Class<E> className) {
		this.className = className;
	}
	
	@Override
	public List<E> getAll() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<E> list = new ArrayList<>();
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
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<E> list = new ArrayList<>();
			Query _query_ =  session.createQuery(hqlQuery);
			list = _query_.getResultList();
			return list;
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return null;
	}
	
	@Override
	public E findById(UUID id) {
		E e = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query = session.createQuery("FROM " + className.getSimpleName()
				+" WHERE id =: id"
			);
			query.setParameter("id", id);
			e = (E)query.getSingleResult();
		}catch (Exception exception){
			exception.printStackTrace();
		}
		return e;
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
			session.save(e);
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
