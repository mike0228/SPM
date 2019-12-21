package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.GradesEntryProof;
import cn.edu.njust.dev.ses.main.model.GradesEntryProofExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GradesEntryProofMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    long countByExample(GradesEntryProofExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int deleteByExample(GradesEntryProofExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int deleteByPrimaryKey(Integer gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int insert(GradesEntryProof record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int insertSelective(GradesEntryProof record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    List<GradesEntryProof> selectByExampleWithRowbounds(GradesEntryProofExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    List<GradesEntryProof> selectByExample(GradesEntryProofExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    GradesEntryProof selectByPrimaryKey(Integer gid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int updateByExampleSelective(@Param("record") GradesEntryProof record, @Param("example") GradesEntryProofExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int updateByExample(@Param("record") GradesEntryProof record, @Param("example") GradesEntryProofExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int updateByPrimaryKeySelective(GradesEntryProof record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry_proof
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    int updateByPrimaryKey(GradesEntryProof record);
}