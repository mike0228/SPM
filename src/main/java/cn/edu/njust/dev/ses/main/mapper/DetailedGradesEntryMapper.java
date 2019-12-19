package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.DetailedGradesEntry;
import cn.edu.njust.dev.ses.main.model.DetailedGradesEntryExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface DetailedGradesEntryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detailed_grades_entry
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    long countByExample(DetailedGradesEntryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detailed_grades_entry
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    List<DetailedGradesEntry> selectByExampleWithRowbounds(DetailedGradesEntryExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detailed_grades_entry
     *
     * @mbg.generated Thu Dec 19 17:19:05 CST 2019
     */
    List<DetailedGradesEntry> selectByExample(DetailedGradesEntryExample example);
}