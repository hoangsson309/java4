package service.iml;

import repository.iml.Repository;
import service.IService;

import java.util.List;
import java.util.UUID;

public class Service<E> implements IService<E> {
	
	private Class<E> className;
	private Repository<E> repository = null;
	public Service(Class<E> className) {
		this.className = className;
		repository = new Repository<>(className);
	}
	
	@Override
	public List<E> getAll() {
		return repository.getAll();
	}
	
	@Override
	public E findById(UUID id) {
		return repository.findById(id);
	}
	
	@Override
	public List<E> resultListQuery(String hqlQuery) {
		return repository.resultListQuery(hqlQuery);
	}
	
	@Override
	public E findByParameter(String parameter, String value) {
		return repository.findByParameter(parameter, value);
	}
	
	@Override
	public boolean add(E e) {
		return repository.add(e);
	}
	
	@Override
	public boolean update(E e) {
		return repository.update(e);
	}
	
	@Override
	public boolean delete(E e) {
		return repository.delete(e);
	}
}
