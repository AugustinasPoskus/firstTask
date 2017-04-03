package lt.augus.cdi.dao;

import lt.augus.entities.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CourseDAO {

        @Inject
        private EntityManager em;

        public List<Course> getAllCourse() {
            return em.createNamedQuery("Course.findAll", Course.class).getResultList();
        }

        public void create(Course course) {
            em.persist(course);
        }
    }