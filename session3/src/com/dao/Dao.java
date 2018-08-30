package com.dao;

import java.util.List;

public interface Dao<T> {
	public List<T> getAll();

	public boolean insert(T t);

	public List<T> get(String firstName, String lastName);

	public T get(String email);

	public boolean update(T t);

}
