package repository;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {
	List<E> getAll();
	List<E> resultListQuery(String hqlQuery);
	E findById(UUID id);
	E findByParameter(String parameter, String value);
	boolean add(E e);
	boolean update(E e);
	boolean delete(E e);
}
