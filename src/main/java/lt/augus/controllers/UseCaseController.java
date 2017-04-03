package lt.augus.controllers;

import lombok.Getter;
import lt.augus.cdi.dao.CourseDAO;
import lt.augus.cdi.dao.StudentDAO;
import lt.augus.cdi.dao.UniversityDAO;
import lt.augus.entities.Course;
import lt.augus.entities.Student;
import lt.augus.entities.University;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
public class UseCaseController {

    @Getter
    private Course course = new Course();
    @Getter
    private Student student = new Student();
    @Getter
    private University university = new University();

    @Inject
    private CourseDAO courseDAO;
    @Inject
    private StudentDAO studentDAO;
    @Inject
    private UniversityDAO universityDAO;

    public List<University> getAllUniversities() {
        return universityDAO.getAllUniversities();
    }

    public void createUniversity () {
        universityDAO.create(university);
    }

    @Transactional
    public void createCourseStudent() {
        student.getCourseList().add(course);
        course.getStudentList().add(student);
        courseDAO.create(course);
        //student.setFirstName(null);
        studentDAO.create(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}