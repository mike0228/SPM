package cn.edu.njust.dev.ses.main.model;

public class GlobalParameter {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column global_parameters.key
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private String key;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column global_parameters.value
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private String value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column global_parameters.key
     *
     * @return the value of global_parameters.key
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public String getKey() {
        return key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column global_parameters.key
     *
     * @param key the value for global_parameters.key
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column global_parameters.value
     *
     * @return the value of global_parameters.value
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
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
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}