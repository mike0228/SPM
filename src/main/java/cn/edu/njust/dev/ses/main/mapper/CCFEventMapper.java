package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.CCFEvent;
import cn.edu.njust.dev.ses.main.model.CCFEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CCFEventMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    long countByExample(CCFEventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int deleteByExample(CCFEventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int deleteByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int insert(CCFEvent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int insertSelective(CCFEvent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    List<CCFEvent> selectByExampleWithRowbounds(CCFEventExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    List<CCFEvent> selectByExample(CCFEventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    CCFEvent selectByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int updateByExampleSelective(@Param("record") CCFEvent record, @Param("example") CCFEventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int updateByExample(@Param("record") CCFEvent record, @Param("example") CCFEventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int updateByPrimaryKeySelective(CCFEvent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    int updateByPrimaryKey(CCFEvent record);
}