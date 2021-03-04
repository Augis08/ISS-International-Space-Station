package repositories.peopleInSpace;

import entity.PeopleInSpace;
import repositories.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class PeopleInSpaceRepository extends AbstractRepository<PeopleInSpace, Long> {

    public PeopleInSpaceRepository(EntityManager entityManager) {
        super(entityManager, PeopleInSpace.class);
    }

    @Override
    public List<PeopleInSpace> findAll() {
        return entityManager.createQuery("FROM PeopleInSpace", PeopleInSpace.class).getResultList();
    }
}
