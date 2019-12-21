package cn.edu.njust.dev.ses.main.model;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.uid
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.name
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.student_id
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String studentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.gender
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.id_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String idNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.ethnic_group
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String ethnicGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.admission_year
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private Integer admissionYear;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.institute
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String institute;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.profession
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String profession;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.class_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String classNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.phone_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    private String phoneNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public Student(Integer uid, String name, String studentId, String gender, String idNo, String ethnicGroup, Integer admissionYear, String institute, String profession, String classNo, String phoneNo) {
        this.uid = uid;
        this.name = name;
        this.studentId = studentId;
        this.gender = gender;
        this.idNo = idNo;
        this.ethnicGroup = ethnicGroup;
        this.admissionYear = admissionYear;
        this.institute = institute;
        this.profession = profession;
        this.classNo = classNo;
        this.phoneNo = phoneNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public Student() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.uid
     *
     * @return the value of student.uid
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.uid
     *
     * @param uid the value for student.uid
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.name
     *
     * @return the value of student.name
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.name
     *
     * @param name the value for student.name
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.student_id
     *
     * @return the value of student.student_id
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.student_id
     *
     * @param studentId the value for student.student_id
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.gender
     *
     * @return the value of student.gender
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.gender
     *
     * @param gender the value for student.gender
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.id_no
     *
     * @return the value of student.id_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.id_no
     *
     * @param idNo the value for student.id_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.ethnic_group
     *
     * @return the value of student.ethnic_group
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getEthnicGroup() {
        return ethnicGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.ethnic_group
     *
     * @param ethnicGroup the value for student.ethnic_group
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup == null ? null : ethnicGroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.admission_year
     *
     * @return the value of student.admission_year
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public Integer getAdmissionYear() {
        return admissionYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.admission_year
     *
     * @param admissionYear the value for student.admission_year
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.institute
     *
     * @return the value of student.institute
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.institute
     *
     * @param institute the value for student.institute
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setInstitute(String institute) {
        this.institute = institute == null ? null : institute.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.profession
     *
     * @return the value of student.profession
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getProfession() {
        return profession;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.profession
     *
     * @param profession the value for student.profession
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.class_no
     *
     * @return the value of student.class_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getClassNo() {
        return classNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.class_no
     *
     * @param classNo the value for student.class_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.phone_no
     *
     * @return the value of student.phone_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.phone_no
     *
     * @param phoneNo the value for student.phone_no
     *
     * @mbg.generated Sat Dec 21 13:34:00 CST 2019
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }
}