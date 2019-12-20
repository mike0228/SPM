package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.SelectRankEntry;
import cn.edu.njust.dev.ses.main.model.SelectRankEntryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SelectRankEntryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    long countByExample(SelectRankEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int deleteByExample(SelectRankEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int deleteByPrimaryKey(Integer reid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int insert(SelectRankEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int insertSelective(SelectRankEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    List<SelectRankEntry> selectByExampleWithRowbounds(SelectRankEntryExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    List<SelectRankEntry> selectByExample(SelectRankEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    SelectRankEntry selectByPrimaryKey(Integer reid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") SelectRankEntry record, @Param("example") SelectRankEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByExample(@Param("record") SelectRankEntry record, @Param("example") SelectRankEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByPrimaryKeySelective(SelectRankEntry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table select_rank_entry
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    int updateByPrimaryKey(SelectRankEntry record);
}