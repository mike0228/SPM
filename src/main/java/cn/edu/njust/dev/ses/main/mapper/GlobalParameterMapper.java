package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.GlobalParameter;
import cn.edu.njust.dev.ses.main.model.GlobalParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GlobalParameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    long countByExample(GlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int deleteByExample(GlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int deleteByPrimaryKey(String param);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int insert(GlobalParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int insertSelective(GlobalParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    List<GlobalParameter> selectByExampleWithRowbounds(GlobalParameterExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    List<GlobalParameter> selectByExample(GlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    GlobalParameter selectByPrimaryKey(String param);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByExampleSelective(@Param("record") GlobalParameter record, @Param("example") GlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByExample(@Param("record") GlobalParameter record, @Param("example") GlobalParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByPrimaryKeySelective(GlobalParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    int updateByPrimaryKey(GlobalParameter record);
}