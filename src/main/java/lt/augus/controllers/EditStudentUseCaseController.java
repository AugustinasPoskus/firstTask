package lt.augus.controllers;

import lombok.Getter;
import lt.augus.cdi.dao.CourseDAO;
import lt.augus.cdi.dao.StudentDAO;
import lt.augus.cdi.dao.UniversityDAO;
import lt.augus.entities.Course;
import lt.augus.entities.Student;
import lt.augus.entities.University;
import org.hibernate.Hibernate;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EditStudentUseCaseController implements Serializable {
    @Getter
    private Student selectedStudent;
    @Getter
    private Student conflictingStudent;
    @Getter
    private List<Student> allStudents;
    @Getter
    private List<University> allUniversities;
    @Getter
    private List<Course> allCourses;

    @Inject
    private StudentDAO studentDAO;
    @Inject
    private CourseDAO courseDAO;
    @Inject
    private UniversityDAO universityDAO;

    @PostConstruct
    public void init() {
        reloadAll();
    }

    public void prepareForEditing(Student student) {
        selectedStudent = student;
        conflictingStudent = null;
    }

    @Transactional
    public void updateSelectedStudent() {
        try {
            studentDAO.update(selectedStudent);
            reloadAll();
        } catch (OptimisticLockException ole) {
            conflictingStudent = studentDAO.findById(selectedStudent.getId());
            // Pavyzdys, kaip inicializuoti LAZY ryšį, jei jo reikia HTML puslapyje:
            Hibernate.initialize(conflictingStudent.getCourseList());
            // Pranešam PrimeFaces dialogui, kad užsidaryti dar negalima:
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional
    public void overwriteStudent() {
        selectedStudent.setOptLockVersion(conflictingStudent.getOptLockVersion());
        updateSelectedStudent();
    }

    public void reloadAll() {
        allStudents = studentDAO.getAllStudents();
        allUniversities = universityDAO.getAllUniversities();
        allCourses = courseDAO.getAllCourses();
    }
}
