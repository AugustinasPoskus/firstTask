package lt.augus.controllers;

import lombok.Getter;
import lt.augus.mybatis.dao.CourseMapper;
import lt.augus.mybatis.dao.StudentCourseMapper;
import lt.augus.mybatis.dao.StudentMapper;
import lt.augus.mybatis.model.Course;
import lt.augus.mybatis.model.Student;
import lt.augus.mybatis.model.StudentCourse;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class IndexController {
    @Getter
    private Course course = new Course();

    @Getter
    private Student student = new Student();

    @Inject
    private StudentMapper studentMapper;

    @Inject
    private CourseMapper courseMapper;

    @Inject
    private StudentCourseMapper studentCourseMapper;

    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Transactional
    public void createStudent() {
            courseMapper.insert(course);
            //student.setFirstName(null);
            studentMapper.insert(student);
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setCourseId(course.getId());
            studentCourse.setStudentId(student.getId());
            studentCourseMapper.insert(studentCourse);
    }
}
