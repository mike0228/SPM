package cn.edu.njust.dev.ses.main.model;

public class Teacher {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.work_id
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private String workId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.name
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.uid
     *
     * @return the value of teacher.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.uid
     *
     * @param uid the value for teacher.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.work_id
     *
     * @return the value of teacher.work_id
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.work_id
     *
     * @param workId the value for teacher.work_id
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.name
     *
     * @return the value of teacher.name
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.name
     *
     * @param name the value for teacher.name
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}