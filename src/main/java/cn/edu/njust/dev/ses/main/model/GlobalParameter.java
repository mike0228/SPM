package cn.edu.njust.dev.ses.main.model;

public class GlobalParameter {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column global_parameters.param
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    private String param;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column global_parameters.value
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    private String value;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    public GlobalParameter(String param, String value) {
        this.param = param;
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table global_parameters
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    public GlobalParameter() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column global_parameters.param
     *
     * @return the value of global_parameters.param
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    public String getParam() {
        return param;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column global_parameters.param
     *
     * @param param the value for global_parameters.param
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column global_parameters.value
     *
     * @return the value of global_parameters.value
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column global_parameters.value
     *
     * @param value the value for global_parameters.value
     *
     * @mbg.generated Sat Dec 21 21:20:03 CST 2019
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}