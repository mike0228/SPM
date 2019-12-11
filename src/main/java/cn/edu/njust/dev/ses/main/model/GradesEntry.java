package cn.edu.njust.dev.ses.main.model;

public class GradesEntry {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry.gid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer gid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry.type
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry.grades
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer grades;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry.eid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer eid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry.max_grades
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer maxGrades;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry.gid
     *
     * @return the value of grades_entry.gid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry.gid
     *
     * @param gid the value for grades_entry.gid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry.type
     *
     * @return the value of grades_entry.type
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry.type
     *
     * @param type the value for grades_entry.type
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry.grades
     *
     * @return the value of grades_entry.grades
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getGrades() {
        return grades;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry.grades
     *
     * @param grades the value for grades_entry.grades
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setGrades(Integer grades) {
        this.grades = grades;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry.eid
     *
     * @return the value of grades_entry.eid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry.eid
     *
     * @param eid the value for grades_entry.eid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry.uid
     *
     * @return the value of grades_entry.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry.uid
     *
     * @param uid the value for grades_entry.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry.max_grades
     *
     * @return the value of grades_entry.max_grades
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getMaxGrades() {
        return maxGrades;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry.max_grades
     *
     * @param maxGrades the value for grades_entry.max_grades
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setMaxGrades(Integer maxGrades) {
        this.maxGrades = maxGrades;
    }
}