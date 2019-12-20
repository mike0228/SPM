package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.UserSession;
import cn.edu.njust.dev.ses.main.model.UserSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserSessionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    long countByExample(UserSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int deleteByExample(UserSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int deleteByPrimaryKey(Integer sessionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int insert(UserSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int insertSelective(UserSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    List<UserSession> selectByExampleWithRowbounds(UserSessionExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    List<UserSession> selectByExample(UserSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    UserSession selectByPrimaryKey(Integer sessionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserSession record, @Param("example") UserSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByExample(@Param("record") UserSession record, @Param("example") UserSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByPrimaryKeySelective(UserSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByPrimaryKey(UserSession record);
}