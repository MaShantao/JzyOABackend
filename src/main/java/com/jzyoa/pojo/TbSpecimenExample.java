package com.jzyoa.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbSpecimenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSpecimenExample() {
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

        public Criteria andSpecimenCodeIsNull() {
            addCriterion("specimen_code is null");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeIsNotNull() {
            addCriterion("specimen_code is not null");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeEqualTo(String value) {
            addCriterion("specimen_code =", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeNotEqualTo(String value) {
            addCriterion("specimen_code <>", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeGreaterThan(String value) {
            addCriterion("specimen_code >", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeGreaterThanOrEqualTo(String value) {
            addCriterion("specimen_code >=", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeLessThan(String value) {
            addCriterion("specimen_code <", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeLessThanOrEqualTo(String value) {
            addCriterion("specimen_code <=", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeLike(String value) {
            addCriterion("specimen_code like", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeNotLike(String value) {
            addCriterion("specimen_code not like", value, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeIn(List<String> values) {
            addCriterion("specimen_code in", values, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeNotIn(List<String> values) {
            addCriterion("specimen_code not in", values, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeBetween(String value1, String value2) {
            addCriterion("specimen_code between", value1, value2, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andSpecimenCodeNotBetween(String value1, String value2) {
            addCriterion("specimen_code not between", value1, value2, "specimenCode");
            return (Criteria) this;
        }

        public Criteria andBedNumIsNull() {
            addCriterion("bed_num is null");
            return (Criteria) this;
        }

        public Criteria andBedNumIsNotNull() {
            addCriterion("bed_num is not null");
            return (Criteria) this;
        }

        public Criteria andBedNumEqualTo(String value) {
            addCriterion("bed_num =", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotEqualTo(String value) {
            addCriterion("bed_num <>", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumGreaterThan(String value) {
            addCriterion("bed_num >", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumGreaterThanOrEqualTo(String value) {
            addCriterion("bed_num >=", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLessThan(String value) {
            addCriterion("bed_num <", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLessThanOrEqualTo(String value) {
            addCriterion("bed_num <=", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLike(String value) {
            addCriterion("bed_num like", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotLike(String value) {
            addCriterion("bed_num not like", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumIn(List<String> values) {
            addCriterion("bed_num in", values, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotIn(List<String> values) {
            addCriterion("bed_num not in", values, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumBetween(String value1, String value2) {
            addCriterion("bed_num between", value1, value2, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotBetween(String value1, String value2) {
            addCriterion("bed_num not between", value1, value2, "bedNum");
            return (Criteria) this;
        }

        public Criteria andHosIdIsNull() {
            addCriterion("specimen.hos_id is null");
            return (Criteria) this;
        }

        public Criteria andHosIdIsNotNull() {
            addCriterion("specimen.hos_id is not null");
            return (Criteria) this;
        }

        public Criteria andHosIdEqualTo(Integer value) {
            addCriterion("specimen.hos_id =", value, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdNotEqualTo(Integer value) {
            addCriterion("specimen.hos_id <>", value, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdGreaterThan(Integer value) {
            addCriterion("specimen.hos_id >", value, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("specimen.hos_id >=", value, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdLessThan(Integer value) {
            addCriterion("specimen.hos_id <", value, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdLessThanOrEqualTo(Integer value) {
            addCriterion("specimen.hos_id <=", value, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdIn(List<Integer> values) {
            addCriterion("specimen.hos_id in", values, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdNotIn(List<Integer> values) {
            addCriterion("specimen.hos_id not in", values, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdBetween(Integer value1, Integer value2) {
            addCriterion("specimen.hos_id between", value1, value2, "hosId");
            return (Criteria) this;
        }

        public Criteria andHosIdNotBetween(Integer value1, Integer value2) {
            addCriterion("specimen.hos_id not between", value1, value2, "hosId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("department.dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("department.dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("department.dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("department.dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("department.dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department.dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("department.dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("department.dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("department.dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("department.dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("department.dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department.dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNull() {
            addCriterion("doctor.doc_id is null");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNotNull() {
            addCriterion("doctor.doc_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocIdEqualTo(Integer value) {
            addCriterion("doctor.doc_id =", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotEqualTo(Integer value) {
            addCriterion("doctor.doc_id <>", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThan(Integer value) {
            addCriterion("doctor.doc_id >", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor.doc_id >=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThan(Integer value) {
            addCriterion("doctor.doc_id <", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThanOrEqualTo(Integer value) {
            addCriterion("doctor.doc_id <=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdIn(List<Integer> values) {
            addCriterion("doctor.doc_id in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotIn(List<Integer> values) {
            addCriterion("doctor.doc_id not in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdBetween(Integer value1, Integer value2) {
            addCriterion("doctor.doc_id between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor.doc_id not between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDoorNumIsNull() {
            addCriterion("door_num is null");
            return (Criteria) this;
        }

        public Criteria andDoorNumIsNotNull() {
            addCriterion("door_num is not null");
            return (Criteria) this;
        }

        public Criteria andDoorNumEqualTo(String value) {
            addCriterion("door_num =", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotEqualTo(String value) {
            addCriterion("door_num <>", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumGreaterThan(String value) {
            addCriterion("door_num >", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumGreaterThanOrEqualTo(String value) {
            addCriterion("door_num >=", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumLessThan(String value) {
            addCriterion("door_num <", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumLessThanOrEqualTo(String value) {
            addCriterion("door_num <=", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumLike(String value) {
            addCriterion("door_num like", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotLike(String value) {
            addCriterion("door_num not like", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumIn(List<String> values) {
            addCriterion("door_num in", values, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotIn(List<String> values) {
            addCriterion("door_num not in", values, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumBetween(String value1, String value2) {
            addCriterion("door_num between", value1, value2, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotBetween(String value1, String value2) {
            addCriterion("door_num not between", value1, value2, "doorNum");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNull() {
            addCriterion("patient_name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("patient_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("patient_name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("patient_name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("patient_name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("patient_name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("patient_name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("patient_name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("patient_name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("patient_name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("patient_name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("patient_name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("patient_name not between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIsNull() {
            addCriterion("patient_age is null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIsNotNull() {
            addCriterion("patient_age is not null");
            return (Criteria) this;
        }

        public Criteria andPatientAgeEqualTo(Integer value) {
            addCriterion("patient_age =", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotEqualTo(Integer value) {
            addCriterion("patient_age <>", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeGreaterThan(Integer value) {
            addCriterion("patient_age >", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_age >=", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeLessThan(Integer value) {
            addCriterion("patient_age <", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeLessThanOrEqualTo(Integer value) {
            addCriterion("patient_age <=", value, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeIn(List<Integer> values) {
            addCriterion("patient_age in", values, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotIn(List<Integer> values) {
            addCriterion("patient_age not in", values, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeBetween(Integer value1, Integer value2) {
            addCriterion("patient_age between", value1, value2, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_age not between", value1, value2, "patientAge");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneIsNull() {
            addCriterion("patient_tellphone is null");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneIsNotNull() {
            addCriterion("patient_tellphone is not null");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneEqualTo(String value) {
            addCriterion("patient_tellphone =", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneNotEqualTo(String value) {
            addCriterion("patient_tellphone <>", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneGreaterThan(String value) {
            addCriterion("patient_tellphone >", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("patient_tellphone >=", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneLessThan(String value) {
            addCriterion("patient_tellphone <", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneLessThanOrEqualTo(String value) {
            addCriterion("patient_tellphone <=", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneLike(String value) {
            addCriterion("patient_tellphone like", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneNotLike(String value) {
            addCriterion("patient_tellphone not like", value, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneIn(List<String> values) {
            addCriterion("patient_tellphone in", values, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneNotIn(List<String> values) {
            addCriterion("patient_tellphone not in", values, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneBetween(String value1, String value2) {
            addCriterion("patient_tellphone between", value1, value2, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientTellphoneNotBetween(String value1, String value2) {
            addCriterion("patient_tellphone not between", value1, value2, "patientTellphone");
            return (Criteria) this;
        }

        public Criteria andPatientGenderIsNull() {
            addCriterion("patient_gender is null");
            return (Criteria) this;
        }

        public Criteria andPatientGenderIsNotNull() {
            addCriterion("patient_gender is not null");
            return (Criteria) this;
        }

        public Criteria andPatientGenderEqualTo(String value) {
            addCriterion("patient_gender =", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotEqualTo(String value) {
            addCriterion("patient_gender <>", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderGreaterThan(String value) {
            addCriterion("patient_gender >", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderGreaterThanOrEqualTo(String value) {
            addCriterion("patient_gender >=", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderLessThan(String value) {
            addCriterion("patient_gender <", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderLessThanOrEqualTo(String value) {
            addCriterion("patient_gender <=", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderLike(String value) {
            addCriterion("patient_gender like", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotLike(String value) {
            addCriterion("patient_gender not like", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderIn(List<String> values) {
            addCriterion("patient_gender in", values, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotIn(List<String> values) {
            addCriterion("patient_gender not in", values, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderBetween(String value1, String value2) {
            addCriterion("patient_gender between", value1, value2, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotBetween(String value1, String value2) {
            addCriterion("patient_gender not between", value1, value2, "patientGender");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdIsNull() {
            addCriterion("specimen_type_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdIsNotNull() {
            addCriterion("specimen_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdEqualTo(Integer value) {
            addCriterion("specimen_type_id =", value, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdNotEqualTo(Integer value) {
            addCriterion("specimen_type_id <>", value, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdGreaterThan(Integer value) {
            addCriterion("specimen_type_id >", value, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("specimen_type_id >=", value, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdLessThan(Integer value) {
            addCriterion("specimen_type_id <", value, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("specimen_type_id <=", value, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdIn(List<Integer> values) {
            addCriterion("specimen_type_id in", values, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdNotIn(List<Integer> values) {
            addCriterion("specimen_type_id not in", values, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("specimen_type_id between", value1, value2, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("specimen_type_id not between", value1, value2, "specimenTypeId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdIsNull() {
            addCriterion("specimen_situation_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdIsNotNull() {
            addCriterion("specimen_situation_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdEqualTo(Integer value) {
            addCriterion("specimen_situation_id =", value, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdNotEqualTo(Integer value) {
            addCriterion("specimen_situation_id <>", value, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdGreaterThan(Integer value) {
            addCriterion("specimen_situation_id >", value, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("specimen_situation_id >=", value, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdLessThan(Integer value) {
            addCriterion("specimen_situation_id <", value, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdLessThanOrEqualTo(Integer value) {
            addCriterion("specimen_situation_id <=", value, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdIn(List<Integer> values) {
            addCriterion("specimen_situation_id in", values, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdNotIn(List<Integer> values) {
            addCriterion("specimen_situation_id not in", values, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdBetween(Integer value1, Integer value2) {
            addCriterion("specimen_situation_id between", value1, value2, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenSituationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("specimen_situation_id not between", value1, value2, "specimenSituationId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdIsNull() {
            addCriterion("specimen_status_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdIsNotNull() {
            addCriterion("specimen_status_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdEqualTo(Integer value) {
            addCriterion("specimen_status_id =", value, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdNotEqualTo(Integer value) {
            addCriterion("specimen_status_id <>", value, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdGreaterThan(Integer value) {
            addCriterion("specimen_status_id >", value, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("specimen_status_id >=", value, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdLessThan(Integer value) {
            addCriterion("specimen_status_id <", value, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("specimen_status_id <=", value, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdIn(List<Integer> values) {
            addCriterion("specimen_status_id in", values, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdNotIn(List<Integer> values) {
            addCriterion("specimen_status_id not in", values, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("specimen_status_id between", value1, value2, "specimenStatusId");
            return (Criteria) this;
        }

        public Criteria andSpecimenStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("specimen_status_id not between", value1, value2, "specimenStatusId");
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
            addCriterion("specimen.create_time =", value, "specimen.create_time");
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
            addCriterion("specimen.create_time between", value1, value2, "specimen.create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeIsNull() {
            addCriterion("recv_time is null");
            return (Criteria) this;
        }

        public Criteria andRecvTimeIsNotNull() {
            addCriterion("recv_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecvTimeEqualTo(String value) {
            addCriterion("specimen.recv_time =", value, "specimen.recv_time");
            return (Criteria) this;
        }

        public Criteria andRecvTimeNotEqualTo(String value) {
            addCriterion("recv_time <>", value, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeGreaterThan(String value) {
            addCriterion("recv_time >", value, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeGreaterThanOrEqualTo(String value) {
            addCriterion("recv_time >=", value, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeLessThan(String value) {
            addCriterion("recv_time <", value, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeLessThanOrEqualTo(String value) {
            addCriterion("recv_time <=", value, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeLike(String value) {
            addCriterion("recv_time like", value, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeNotLike(String value) {
            addCriterion("recv_time not like", value, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeIn(List<String> values) {
            addCriterion("recv_time in", values, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeNotIn(List<String> values) {
            addCriterion("recv_time not in", values, "recvTime");
            return (Criteria) this;
        }

        public Criteria andRecvTimeBetween(String value1, String value2) {
            addCriterion("specimen.recv_time between", value1, value2, "specimen.recvTime");
            return (Criteria) this;
        }
        
        
        public Criteria andRecvTimeNotBetween(String value1, String value2) {
            addCriterion("recv_time not between", value1, value2, "recvTime");
            return (Criteria) this;
        }
        
        // 报告时间
        public Criteria andReportCreateTimeBetween(String value1, String value2) {
            addCriterion("report.create_time between", value1, value2, "report.create_time");
            return (Criteria) this;
        }
        
        public Criteria andReportCreateTimeEqualTo(String value) {
            addCriterion("report.create_time =", value, "report.create_time");
            return (Criteria) this;
        }
        public Criteria andTestTypeIdIsNull() {
            addCriterion("test_type_id is null");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdIsNotNull() {
            addCriterion("test_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdEqualTo(Integer value) {
            addCriterion("test_type_id =", value, "testTypeId");
            return (Criteria) this;
        }
        
        public Criteria andPatientTypeIdEqualTo(Integer value) {
            addCriterion("patient_type_id =", value, "patientTypeId");
            return (Criteria) this;
        }
        
        public Criteria andTestTypeIdNotEqualTo(Integer value) {
            addCriterion("test_type_id <>", value, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdGreaterThan(Integer value) {
            addCriterion("test_type_id >", value, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_type_id >=", value, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdLessThan(Integer value) {
            addCriterion("test_type_id <", value, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_type_id <=", value, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdIn(List<Integer> values) {
            addCriterion("test_type_id in", values, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdNotIn(List<Integer> values) {
            addCriterion("test_type_id not in", values, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("test_type_id between", value1, value2, "testTypeId");
            return (Criteria) this;
        }

        public Criteria andTestTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_type_id not between", value1, value2, "testTypeId");
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