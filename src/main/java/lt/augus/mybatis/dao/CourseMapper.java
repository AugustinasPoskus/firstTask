package lt.augus.mybatis.dao;

import java.util.List;
import lt.augus.mybatis.model.Course;
import org.mybatis.cdi.Mapper;

@Mapper
public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Fri Mar 31 23:07:42 EEST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Fri Mar 31 23:07:42 EEST 2017
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Fri Mar 31 23:07:42 EEST 2017
     */
    Course selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Fri Mar 31 23:07:42 EEST 2017
     */
    List<Course> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Fri Mar 31 23:07:42 EEST 2017
     */
    int updateByPrimaryKey(Course record);
}