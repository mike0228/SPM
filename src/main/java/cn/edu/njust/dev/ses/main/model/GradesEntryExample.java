package cn.edu.njust.dev.ses.main.model;

import java.util.ArrayList;
import java.util.List;

public class GradesEntryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public GradesEntryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGradesIsNull() {
            addCriterion("grades is null");
            return (Criteria) this;
        }

        public Criteria andGradesIsNotNull() {
            addCriterion("grades is not null");
            return (Criteria) this;
        }

        public Criteria andGradesEqualTo(Integer value) {
            addCriterion("grades =", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesNotEqualTo(Integer value) {
            addCriterion("grades <>", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesGreaterThan(Integer value) {
            addCriterion("grades >", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesGreaterThanOrEqualTo(Integer value) {
            addCriterion("grades >=", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesLessThan(Integer value) {
            addCriterion("grades <", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesLessThanOrEqualTo(Integer value) {
            addCriterion("grades <=", value, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesIn(List<Integer> values) {
            addCriterion("grades in", values, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesNotIn(List<Integer> values) {
            addCriterion("grades not in", values, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesBetween(Integer value1, Integer value2) {
            addCriterion("grades between", value1, value2, "grades");
            return (Criteria) this;
        }

        public Criteria andGradesNotBetween(Integer value1, Integer value2) {
            addCriterion("grades not between", value1, value2, "grades");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andMaxGradesIsNull() {
            addCriterion("max_grades is null");
            return (Criteria) this;
        }

        public Criteria andMaxGradesIsNotNull() {
            addCriterion("max_grades is not null");
            return (Criteria) this;
        }

        public Criteria andMaxGradesEqualTo(Integer value) {
            addCriterion("max_grades =", value, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesNotEqualTo(Integer value) {
            addCriterion("max_grades <>", value, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesGreaterThan(Integer value) {
            addCriterion("max_grades >", value, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_grades >=", value, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesLessThan(Integer value) {
            addCriterion("max_grades <", value, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesLessThanOrEqualTo(Integer value) {
            addCriterion("max_grades <=", value, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesIn(List<Integer> values) {
            addCriterion("max_grades in", values, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesNotIn(List<Integer> values) {
            addCriterion("max_grades not in", values, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesBetween(Integer value1, Integer value2) {
            addCriterion("max_grades between", value1, value2, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andMaxGradesNotBetween(Integer value1, Integer value2) {
            addCriterion("max_grades not between", value1, value2, "maxGrades");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIsNull() {
            addCriterion("is_approved is null");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIsNotNull() {
            addCriterion("is_approved is not null");
            return (Criteria) this;
        }

        public Criteria andIsApprovedEqualTo(Boolean value) {
            addCriterion("is_approved =", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotEqualTo(Boolean value) {
            addCriterion("is_approved <>", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedGreaterThan(Boolean value) {
            addCriterion("is_approved >", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_approved >=", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedLessThan(Boolean value) {
            addCriterion("is_approved <", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_approved <=", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIn(List<Boolean> values) {
            addCriterion("is_approved in", values, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotIn(List<Boolean> values) {
            addCriterion("is_approved not in", values, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_approved between", value1, value2, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_approved not between", value1, value2, "isApproved");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1IsNull() {
            addCriterion("grades_problem1 is null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1IsNotNull() {
            addCriterion("grades_problem1 is not null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1EqualTo(Integer value) {
            addCriterion("grades_problem1 =", value, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1NotEqualTo(Integer value) {
            addCriterion("grades_problem1 <>", value, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1GreaterThan(Integer value) {
            addCriterion("grades_problem1 >", value, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1GreaterThanOrEqualTo(Integer value) {
            addCriterion("grades_problem1 >=", value, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1LessThan(Integer value) {
            addCriterion("grades_problem1 <", value, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1LessThanOrEqualTo(Integer value) {
            addCriterion("grades_problem1 <=", value, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1In(List<Integer> values) {
            addCriterion("grades_problem1 in", values, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1NotIn(List<Integer> values) {
            addCriterion("grades_problem1 not in", values, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1Between(Integer value1, Integer value2) {
            addCriterion("grades_problem1 between", value1, value2, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem1NotBetween(Integer value1, Integer value2) {
            addCriterion("grades_problem1 not between", value1, value2, "gradesProblem1");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2IsNull() {
            addCriterion("grades_problem2 is null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2IsNotNull() {
            addCriterion("grades_problem2 is not null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2EqualTo(Integer value) {
            addCriterion("grades_problem2 =", value, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2NotEqualTo(Integer value) {
            addCriterion("grades_problem2 <>", value, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2GreaterThan(Integer value) {
            addCriterion("grades_problem2 >", value, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2GreaterThanOrEqualTo(Integer value) {
            addCriterion("grades_problem2 >=", value, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2LessThan(Integer value) {
            addCriterion("grades_problem2 <", value, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2LessThanOrEqualTo(Integer value) {
            addCriterion("grades_problem2 <=", value, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2In(List<Integer> values) {
            addCriterion("grades_problem2 in", values, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2NotIn(List<Integer> values) {
            addCriterion("grades_problem2 not in", values, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2Between(Integer value1, Integer value2) {
            addCriterion("grades_problem2 between", value1, value2, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem2NotBetween(Integer value1, Integer value2) {
            addCriterion("grades_problem2 not between", value1, value2, "gradesProblem2");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3IsNull() {
            addCriterion("grades_problem3 is null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3IsNotNull() {
            addCriterion("grades_problem3 is not null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3EqualTo(Integer value) {
            addCriterion("grades_problem3 =", value, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3NotEqualTo(Integer value) {
            addCriterion("grades_problem3 <>", value, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3GreaterThan(Integer value) {
            addCriterion("grades_problem3 >", value, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3GreaterThanOrEqualTo(Integer value) {
            addCriterion("grades_problem3 >=", value, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3LessThan(Integer value) {
            addCriterion("grades_problem3 <", value, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3LessThanOrEqualTo(Integer value) {
            addCriterion("grades_problem3 <=", value, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3In(List<Integer> values) {
            addCriterion("grades_problem3 in", values, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3NotIn(List<Integer> values) {
            addCriterion("grades_problem3 not in", values, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3Between(Integer value1, Integer value2) {
            addCriterion("grades_problem3 between", value1, value2, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem3NotBetween(Integer value1, Integer value2) {
            addCriterion("grades_problem3 not between", value1, value2, "gradesProblem3");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4IsNull() {
            addCriterion("grades_problem4 is null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4IsNotNull() {
            addCriterion("grades_problem4 is not null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4EqualTo(Integer value) {
            addCriterion("grades_problem4 =", value, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4NotEqualTo(Integer value) {
            addCriterion("grades_problem4 <>", value, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4GreaterThan(Integer value) {
            addCriterion("grades_problem4 >", value, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4GreaterThanOrEqualTo(Integer value) {
            addCriterion("grades_problem4 >=", value, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4LessThan(Integer value) {
            addCriterion("grades_problem4 <", value, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4LessThanOrEqualTo(Integer value) {
            addCriterion("grades_problem4 <=", value, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4In(List<Integer> values) {
            addCriterion("grades_problem4 in", values, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4NotIn(List<Integer> values) {
            addCriterion("grades_problem4 not in", values, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4Between(Integer value1, Integer value2) {
            addCriterion("grades_problem4 between", value1, value2, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem4NotBetween(Integer value1, Integer value2) {
            addCriterion("grades_problem4 not between", value1, value2, "gradesProblem4");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5IsNull() {
            addCriterion("grades_problem5 is null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5IsNotNull() {
            addCriterion("grades_problem5 is not null");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5EqualTo(Integer value) {
            addCriterion("grades_problem5 =", value, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5NotEqualTo(Integer value) {
            addCriterion("grades_problem5 <>", value, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5GreaterThan(Integer value) {
            addCriterion("grades_problem5 >", value, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5GreaterThanOrEqualTo(Integer value) {
            addCriterion("grades_problem5 >=", value, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5LessThan(Integer value) {
            addCriterion("grades_problem5 <", value, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5LessThanOrEqualTo(Integer value) {
            addCriterion("grades_problem5 <=", value, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5In(List<Integer> values) {
            addCriterion("grades_problem5 in", values, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5NotIn(List<Integer> values) {
            addCriterion("grades_problem5 not in", values, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5Between(Integer value1, Integer value2) {
            addCriterion("grades_problem5 between", value1, value2, "gradesProblem5");
            return (Criteria) this;
        }

        public Criteria andGradesProblem5NotBetween(Integer value1, Integer value2) {
            addCriterion("grades_problem5 not between", value1, value2, "gradesProblem5");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table grades_entry
     *
     * @mbg.generated do_not_delete_during_merge Wed Dec 18 16:26:00 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table grades_entry
     *
     * @mbg.generated Wed Dec 18 16:26:00 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}