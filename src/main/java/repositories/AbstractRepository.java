package repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AbstractRepository <T, ID> implements CrudRepository<T,ID> {

    protected final EntityManager entityManager;
    private final Class<? extends T> entityClass;

    public AbstractRepository(EntityManager entityManager, Class<? extends T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public T find(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        boolean isTransactionActive = transaction.isActive();
        if(!isTransactionActive)
            transaction.begin();
        entityManager.persist(entity);
        if(!isTransactionActive)
            transaction.commit();
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }
    @Override
    public List<T> findAll() {
        return null;
    }
}
