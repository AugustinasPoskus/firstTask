package lt.augus.cdi.dao;

import lt.augus.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@ApplicationScoped
public class StudentDAO {

    @Inject
    private EntityManager em;

    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public void create(Student student) {
        em.persist(student);
    }

    public Student createTest(Student student) {
        return em.merge(student);
    }

    public void update(Student student) {
        em.merge(student);
//        em.flush();
    }

    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }
}