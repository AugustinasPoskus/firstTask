package lt.augus.cdi.dao;

import lt.augus.entities.University;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UniversityDAO {

    @Inject
    private EntityManager em;

    public List<University> getAllUniversities() {
        return em.createNamedQuery("University.findAll", University.class).getResultList();
    }

    public void create(University university) {
        em.persist(university);
    }
}