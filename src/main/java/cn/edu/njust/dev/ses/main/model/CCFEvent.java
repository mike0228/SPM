package cn.edu.njust.dev.ses.main.model;

import java.util.Date;

public class CCFEvent {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ccf_event.eid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer eid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ccf_event.exam_no
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer examNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ccf_event.exam_time
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Date examTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ccf_event.select_exam_time
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Date selectExamTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ccf_event.appli_deadline
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Date appliDeadline;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ccf_event.can_apply
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Byte canApply;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ccf_event.appli_starts_on
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Date appliStartsOn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ccf_event.eid
     *
     * @return the value of ccf_event.eid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ccf_event.eid
     *
     * @param eid the value for ccf_event.eid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ccf_event.exam_no
     *
     * @return the value of ccf_event.exam_no
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getExamNo() {
        return examNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ccf_event.exam_no
     *
     * @param examNo the value for ccf_event.exam_no
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setExamNo(Integer examNo) {
        this.examNo = examNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ccf_event.exam_time
     *
     * @return the value of ccf_event.exam_time
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ccf_event.exam_time
     *
     * @param examTime the value for ccf_event.exam_time
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ccf_event.select_exam_time
     *
     * @return the value of ccf_event.select_exam_time
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Date getSelectExamTime() {
        return selectExamTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ccf_event.select_exam_time
     *
     * @param selectExamTime the value for ccf_event.select_exam_time
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setSelectExamTime(Date selectExamTime) {
        this.selectExamTime = selectExamTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ccf_event.appli_deadline
     *
     * @return the value of ccf_event.appli_deadline
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Date getAppliDeadline() {
        return appliDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ccf_event.appli_deadline
     *
     * @param appliDeadline the value for ccf_event.appli_deadline
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setAppliDeadline(Date appliDeadline) {
        this.appliDeadline = appliDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ccf_event.can_apply
     *
     * @return the value of ccf_event.can_apply
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Byte getCanApply() {
        return canApply;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ccf_event.can_apply
     *
     * @param canApply the value for ccf_event.can_apply
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setCanApply(Byte canApply) {
        this.canApply = canApply;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ccf_event.appli_starts_on
     *
     * @return the value of ccf_event.appli_starts_on
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Date getAppliStartsOn() {
        return appliStartsOn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ccf_event.appli_starts_on
     *
     * @param appliStartsOn the value for ccf_event.appli_starts_on
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setAppliStartsOn(Date appliStartsOn) {
        this.appliStartsOn = appliStartsOn;
    }
}