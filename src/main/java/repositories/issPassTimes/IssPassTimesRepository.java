package repositories.issPassTimes;

import entity.IssPassTimes;
import repositories.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class IssPassTimesRepository extends AbstractRepository<IssPassTimes, Long> {

    public IssPassTimesRepository(EntityManager entityManager) {
        super(entityManager, IssPassTimes.class);
    }

    @Override
    public List<IssPassTimes> findAll() {
        return entityManager.createQuery("FROM IssPassTimes", IssPassTimes.class).getResultList();
    }
}
