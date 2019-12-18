package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.GradesEntry;
import cn.edu.njust.dev.ses.main.model.GradesEntryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GradesEntryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    long countByExample(GradesEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int deleteByExample(GradesEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int deleteByPrimaryKey(Integer gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int insert(GradesEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int insertSelective(GradesEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    List<GradesEntry> selectByExampleWithRowbounds(GradesEntryExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    List<GradesEntry> selectByExample(GradesEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    GradesEntry selectByPrimaryKey(Integer gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int updateByExampleSelective(@Param("record") GradesEntry record, @Param("example") GradesEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int updateByExample(@Param("record") GradesEntry record, @Param("example") GradesEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int updateByPrimaryKeySelective(GradesEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    int updateByPrimaryKey(GradesEntry record);
}