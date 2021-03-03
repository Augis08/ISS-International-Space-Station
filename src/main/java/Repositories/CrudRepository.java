package Repositories;

import java.util.List;

public interface CrudRepository <T, ID> {
    T find(ID id);
    List<T> findAll();
    void save(T entity);
    void delete(T entity);
}
