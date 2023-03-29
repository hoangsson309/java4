package service;

import java.util.List;
import java.util.UUID;

public interface IService<E> {
	List<E> getAll();
	E findById(UUID id);
	List<E> resultListQuery(String hqlQuery);
	E findByParameter(String parameter, String value);
	boolean add(E e);
	boolean update(E e);
	boolean delete(E e);
}
