package service;

import java.util.List;

public interface IService<E> {
	List<E> getAll();
	List<E> resultListQuery(String hqlQuery);
	E findByParameter(String parameter, String value);
	boolean add(E e);
	boolean update(E e);
	boolean delete(E e);
}
