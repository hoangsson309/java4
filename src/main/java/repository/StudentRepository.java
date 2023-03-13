package repository;

import model.Student;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	private Session session;
	private List<Student> list;
	
	public StudentRepository(){
		session = HibernateUtil.getSessionFactory().openSession();
		list = new ArrayList<>();
	}
	
	public List<Student> getAll(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query = session.createQuery("FROM Student ", Student.class);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
			return list;
	}
	
	public static void main(String[] args) {
		StudentRepository a = new StudentRepository();
		List<Student> list = a.getAll();
		System.out.println(list.size());
	}
}
