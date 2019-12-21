package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.Student;
import cn.edu.njust.dev.ses.main.model.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    long countByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int deleteByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    List<Student> selectByExampleWithRowbounds(StudentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    List<Student> selectByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);
}