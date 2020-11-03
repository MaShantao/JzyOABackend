package com.marico.ncovreportsystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Integer value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Integer value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Integer value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Integer value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Integer> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Integer> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Integer value1, Integer value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdIsNull() {
            addCriterion("specimen_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdIsNotNull() {
            addCriterion("specimen_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdEqualTo(Integer value) {
            addCriterion("specimen_id =", value, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdNotEqualTo(Integer value) {
            addCriterion("specimen_id <>", value, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdGreaterThan(Integer value) {
            addCriterion("specimen_id >", value, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("specimen_id >=", value, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdLessThan(Integer value) {
            addCriterion("specimen_id <", value, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdLessThanOrEqualTo(Integer value) {
            addCriterion("specimen_id <=", value, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdIn(List<Integer> values) {
            addCriterion("specimen_id in", values, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdNotIn(List<Integer> values) {
            addCriterion("specimen_id not in", values, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdBetween(Integer value1, Integer value2) {
            addCriterion("specimen_id between", value1, value2, "specimenId");
            return (Criteria) this;
        }

        public Criteria andSpecimenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("specimen_id not between", value1, value2, "specimenId");
            return (Criteria) this;
        }

        public Criteria andReporterIdIsNull() {
            addCriterion("reporter_id is null");
            return (Criteria) this;
        }

        public Criteria andReporterIdIsNotNull() {
            addCriterion("reporter_id is not null");
            return (Criteria) this;
        }

        public Criteria andReporterIdEqualTo(Integer value) {
            addCriterion("reporter_id =", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdNotEqualTo(Integer value) {
            addCriterion("reporter_id <>", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdGreaterThan(Integer value) {
            addCriterion("reporter_id >", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reporter_id >=", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdLessThan(Integer value) {
            addCriterion("reporter_id <", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdLessThanOrEqualTo(Integer value) {
            addCriterion("reporter_id <=", value, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdIn(List<Integer> values) {
            addCriterion("reporter_id in", values, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdNotIn(List<Integer> values) {
            addCriterion("reporter_id not in", values, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdBetween(Integer value1, Integer value2) {
            addCriterion("reporter_id between", value1, value2, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReporterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reporter_id not between", value1, value2, "reporterId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIsNull() {
            addCriterion("reviewer_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIsNotNull() {
            addCriterion("reviewer_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerIdEqualTo(Integer value) {
            addCriterion("reviewer_id =", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotEqualTo(Integer value) {
            addCriterion("reviewer_id <>", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdGreaterThan(Integer value) {
            addCriterion("reviewer_id >", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reviewer_id >=", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdLessThan(Integer value) {
            addCriterion("reviewer_id <", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdLessThanOrEqualTo(Integer value) {
            addCriterion("reviewer_id <=", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIn(List<Integer> values) {
            addCriterion("reviewer_id in", values, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotIn(List<Integer> values) {
            addCriterion("reviewer_id not in", values, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdBetween(Integer value1, Integer value2) {
            addCriterion("reviewer_id between", value1, value2, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reviewer_id not between", value1, value2, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdIsNull() {
            addCriterion("specimen_result_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdIsNotNull() {
            addCriterion("specimen_result_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdEqualTo(Integer value) {
            addCriterion("specimen_result_id =", value, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdNotEqualTo(Integer value) {
            addCriterion("specimen_result_id <>", value, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdGreaterThan(Integer value) {
            addCriterion("specimen_result_id >", value, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("specimen_result_id >=", value, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdLessThan(Integer value) {
            addCriterion("specimen_result_id <", value, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdLessThanOrEqualTo(Integer value) {
            addCriterion("specimen_result_id <=", value, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdIn(List<Integer> values) {
            addCriterion("specimen_result_id in", values, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdNotIn(List<Integer> values) {
            addCriterion("specimen_result_id not in", values, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdBetween(Integer value1, Integer value2) {
            addCriterion("specimen_result_id between", value1, value2, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andSpecimenResultIdNotBetween(Integer value1, Integer value2) {
            addCriterion("specimen_result_id not between", value1, value2, "specimenResultId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdIsNull() {
            addCriterion("reference_value_id is null");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdIsNotNull() {
            addCriterion("reference_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdEqualTo(Integer value) {
            addCriterion("reference_value_id =", value, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdNotEqualTo(Integer value) {
            addCriterion("reference_value_id <>", value, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdGreaterThan(Integer value) {
            addCriterion("reference_value_id >", value, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reference_value_id >=", value, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdLessThan(Integer value) {
            addCriterion("reference_value_id <", value, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdLessThanOrEqualTo(Integer value) {
            addCriterion("reference_value_id <=", value, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdIn(List<Integer> values) {
            addCriterion("reference_value_id in", values, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdNotIn(List<Integer> values) {
            addCriterion("reference_value_id not in", values, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdBetween(Integer value1, Integer value2) {
            addCriterion("reference_value_id between", value1, value2, "referenceValueId");
            return (Criteria) this;
        }

        public Criteria andReferenceValueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reference_value_id not between", value1, value2, "referenceValueId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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