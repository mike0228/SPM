package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.Application;
import cn.edu.njust.dev.ses.main.model.ApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ApplicationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    long countByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int deleteByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int deleteByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int insert(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int insertSelective(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    List<Application> selectByExampleWithRowbounds(ApplicationExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    List<Application> selectByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    Application selectByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByPrimaryKeySelective(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByPrimaryKey(Application record);
}