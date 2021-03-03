package Repositories.issSpeed;

import Entity.IssSpeed;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class IssSpeedRepository extends AbstractRepository<IssSpeed, Long> {

    public IssSpeedRepository(EntityManager entityManager) {
        super(entityManager, IssSpeed.class);
    }

    @Override
    public List<IssSpeed> findAll() {
       return entityManager.createQuery("FROM IssSpeed", IssSpeed.class).getResultList();
    }
}
