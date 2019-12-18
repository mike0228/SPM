package cn.edu.njust.dev.ses.main.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CCFEventExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public CCFEventExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
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
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andExamNoIsNull() {
            addCriterion("exam_no is null");
            return (Criteria) this;
        }

        public Criteria andExamNoIsNotNull() {
            addCriterion("exam_no is not null");
            return (Criteria) this;
        }

        public Criteria andExamNoEqualTo(Integer value) {
            addCriterion("exam_no =", value, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoNotEqualTo(Integer value) {
            addCriterion("exam_no <>", value, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoGreaterThan(Integer value) {
            addCriterion("exam_no >", value, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_no >=", value, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoLessThan(Integer value) {
            addCriterion("exam_no <", value, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoLessThanOrEqualTo(Integer value) {
            addCriterion("exam_no <=", value, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoIn(List<Integer> values) {
            addCriterion("exam_no in", values, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoNotIn(List<Integer> values) {
            addCriterion("exam_no not in", values, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoBetween(Integer value1, Integer value2) {
            addCriterion("exam_no between", value1, value2, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamNoNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_no not between", value1, value2, "examNo");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNull() {
            addCriterion("exam_time is null");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNotNull() {
            addCriterion("exam_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamTimeEqualTo(Date value) {
            addCriterion("exam_time =", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotEqualTo(Date value) {
            addCriterion("exam_time <>", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThan(Date value) {
            addCriterion("exam_time >", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("exam_time >=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThan(Date value) {
            addCriterion("exam_time <", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThanOrEqualTo(Date value) {
            addCriterion("exam_time <=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeIn(List<Date> values) {
            addCriterion("exam_time in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotIn(List<Date> values) {
            addCriterion("exam_time not in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeBetween(Date value1, Date value2) {
            addCriterion("exam_time between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotBetween(Date value1, Date value2) {
            addCriterion("exam_time not between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeIsNull() {
            addCriterion("select_exam_time is null");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeIsNotNull() {
            addCriterion("select_exam_time is not null");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeEqualTo(Date value) {
            addCriterion("select_exam_time =", value, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeNotEqualTo(Date value) {
            addCriterion("select_exam_time <>", value, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeGreaterThan(Date value) {
            addCriterion("select_exam_time >", value, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("select_exam_time >=", value, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeLessThan(Date value) {
            addCriterion("select_exam_time <", value, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeLessThanOrEqualTo(Date value) {
            addCriterion("select_exam_time <=", value, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeIn(List<Date> values) {
            addCriterion("select_exam_time in", values, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeNotIn(List<Date> values) {
            addCriterion("select_exam_time not in", values, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeBetween(Date value1, Date value2) {
            addCriterion("select_exam_time between", value1, value2, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andSelectExamTimeNotBetween(Date value1, Date value2) {
            addCriterion("select_exam_time not between", value1, value2, "selectExamTime");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineIsNull() {
            addCriterion("appli_deadline is null");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineIsNotNull() {
            addCriterion("appli_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineEqualTo(Date value) {
            addCriterion("appli_deadline =", value, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineNotEqualTo(Date value) {
            addCriterion("appli_deadline <>", value, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineGreaterThan(Date value) {
            addCriterion("appli_deadline >", value, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("appli_deadline >=", value, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineLessThan(Date value) {
            addCriterion("appli_deadline <", value, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("appli_deadline <=", value, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineIn(List<Date> values) {
            addCriterion("appli_deadline in", values, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineNotIn(List<Date> values) {
            addCriterion("appli_deadline not in", values, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineBetween(Date value1, Date value2) {
            addCriterion("appli_deadline between", value1, value2, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andAppliDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("appli_deadline not between", value1, value2, "appliDeadline");
            return (Criteria) this;
        }

        public Criteria andCanApplyIsNull() {
            addCriterion("can_apply is null");
            return (Criteria) this;
        }

        public Criteria andCanApplyIsNotNull() {
            addCriterion("can_apply is not null");
            return (Criteria) this;
        }

        public Criteria andCanApplyEqualTo(Byte value) {
            addCriterion("can_apply =", value, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyNotEqualTo(Byte value) {
            addCriterion("can_apply <>", value, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyGreaterThan(Byte value) {
            addCriterion("can_apply >", value, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyGreaterThanOrEqualTo(Byte value) {
            addCriterion("can_apply >=", value, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyLessThan(Byte value) {
            addCriterion("can_apply <", value, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyLessThanOrEqualTo(Byte value) {
            addCriterion("can_apply <=", value, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyIn(List<Byte> values) {
            addCriterion("can_apply in", values, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyNotIn(List<Byte> values) {
            addCriterion("can_apply not in", values, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyBetween(Byte value1, Byte value2) {
            addCriterion("can_apply between", value1, value2, "canApply");
            return (Criteria) this;
        }

        public Criteria andCanApplyNotBetween(Byte value1, Byte value2) {
            addCriterion("can_apply not between", value1, value2, "canApply");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnIsNull() {
            addCriterion("appli_starts_on is null");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnIsNotNull() {
            addCriterion("appli_starts_on is not null");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnEqualTo(Date value) {
            addCriterionForJDBCDate("appli_starts_on =", value, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnNotEqualTo(Date value) {
            addCriterionForJDBCDate("appli_starts_on <>", value, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnGreaterThan(Date value) {
            addCriterionForJDBCDate("appli_starts_on >", value, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appli_starts_on >=", value, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnLessThan(Date value) {
            addCriterionForJDBCDate("appli_starts_on <", value, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appli_starts_on <=", value, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnIn(List<Date> values) {
            addCriterionForJDBCDate("appli_starts_on in", values, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnNotIn(List<Date> values) {
            addCriterionForJDBCDate("appli_starts_on not in", values, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appli_starts_on between", value1, value2, "appliStartsOn");
            return (Criteria) this;
        }

        public Criteria andAppliStartsOnNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appli_starts_on not between", value1, value2, "appliStartsOn");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ccf_event
     *
     * @mbg.generated do_not_delete_during_merge Thu Dec 19 01:43:22 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ccf_event
     *
     * @mbg.generated Thu Dec 19 01:43:22 CST 2019
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