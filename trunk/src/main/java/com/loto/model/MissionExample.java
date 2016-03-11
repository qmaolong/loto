package com.loto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MissionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMissionTypeIsNull() {
            addCriterion("mission_type is null");
            return (Criteria) this;
        }

        public Criteria andMissionTypeIsNotNull() {
            addCriterion("mission_type is not null");
            return (Criteria) this;
        }

        public Criteria andMissionTypeEqualTo(String value) {
            addCriterion("mission_type =", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeNotEqualTo(String value) {
            addCriterion("mission_type <>", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeGreaterThan(String value) {
            addCriterion("mission_type >", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mission_type >=", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeLessThan(String value) {
            addCriterion("mission_type <", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeLessThanOrEqualTo(String value) {
            addCriterion("mission_type <=", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeLike(String value) {
            addCriterion("mission_type like", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeNotLike(String value) {
            addCriterion("mission_type not like", value, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeIn(List<String> values) {
            addCriterion("mission_type in", values, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeNotIn(List<String> values) {
            addCriterion("mission_type not in", values, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeBetween(String value1, String value2) {
            addCriterion("mission_type between", value1, value2, "missionType");
            return (Criteria) this;
        }

        public Criteria andMissionTypeNotBetween(String value1, String value2) {
            addCriterion("mission_type not between", value1, value2, "missionType");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andExampleIsNull() {
            addCriterion("example is null");
            return (Criteria) this;
        }

        public Criteria andExampleIsNotNull() {
            addCriterion("example is not null");
            return (Criteria) this;
        }

        public Criteria andExampleEqualTo(String value) {
            addCriterion("example =", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotEqualTo(String value) {
            addCriterion("example <>", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleGreaterThan(String value) {
            addCriterion("example >", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleGreaterThanOrEqualTo(String value) {
            addCriterion("example >=", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleLessThan(String value) {
            addCriterion("example <", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleLessThanOrEqualTo(String value) {
            addCriterion("example <=", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleLike(String value) {
            addCriterion("example like", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotLike(String value) {
            addCriterion("example not like", value, "example");
            return (Criteria) this;
        }

        public Criteria andExampleIn(List<String> values) {
            addCriterion("example in", values, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotIn(List<String> values) {
            addCriterion("example not in", values, "example");
            return (Criteria) this;
        }

        public Criteria andExampleBetween(String value1, String value2) {
            addCriterion("example between", value1, value2, "example");
            return (Criteria) this;
        }

        public Criteria andExampleNotBetween(String value1, String value2) {
            addCriterion("example not between", value1, value2, "example");
            return (Criteria) this;
        }

        public Criteria andCityLimitIsNull() {
            addCriterion("city_limit is null");
            return (Criteria) this;
        }

        public Criteria andCityLimitIsNotNull() {
            addCriterion("city_limit is not null");
            return (Criteria) this;
        }

        public Criteria andCityLimitEqualTo(String value) {
            addCriterion("city_limit =", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitNotEqualTo(String value) {
            addCriterion("city_limit <>", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitGreaterThan(String value) {
            addCriterion("city_limit >", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitGreaterThanOrEqualTo(String value) {
            addCriterion("city_limit >=", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitLessThan(String value) {
            addCriterion("city_limit <", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitLessThanOrEqualTo(String value) {
            addCriterion("city_limit <=", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitLike(String value) {
            addCriterion("city_limit like", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitNotLike(String value) {
            addCriterion("city_limit not like", value, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitIn(List<String> values) {
            addCriterion("city_limit in", values, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitNotIn(List<String> values) {
            addCriterion("city_limit not in", values, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitBetween(String value1, String value2) {
            addCriterion("city_limit between", value1, value2, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andCityLimitNotBetween(String value1, String value2) {
            addCriterion("city_limit not between", value1, value2, "cityLimit");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("paytype is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("paytype is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(Integer value) {
            addCriterion("paytype =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(Integer value) {
            addCriterion("paytype <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(Integer value) {
            addCriterion("paytype >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("paytype >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(Integer value) {
            addCriterion("paytype <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("paytype <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<Integer> values) {
            addCriterion("paytype in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<Integer> values) {
            addCriterion("paytype not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(Integer value1, Integer value2) {
            addCriterion("paytype between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("paytype not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionIsNull() {
            addCriterion("total_commission is null");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionIsNotNull() {
            addCriterion("total_commission is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionEqualTo(BigDecimal value) {
            addCriterion("total_commission =", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionNotEqualTo(BigDecimal value) {
            addCriterion("total_commission <>", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionGreaterThan(BigDecimal value) {
            addCriterion("total_commission >", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_commission >=", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionLessThan(BigDecimal value) {
            addCriterion("total_commission <", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_commission <=", value, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionIn(List<BigDecimal> values) {
            addCriterion("total_commission in", values, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionNotIn(List<BigDecimal> values) {
            addCriterion("total_commission not in", values, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_commission between", value1, value2, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_commission not between", value1, value2, "totalCommission");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("total_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("total_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(Long value) {
            addCriterion("total_count =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(Long value) {
            addCriterion("total_count <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(Long value) {
            addCriterion("total_count >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_count >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(Long value) {
            addCriterion("total_count <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(Long value) {
            addCriterion("total_count <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<Long> values) {
            addCriterion("total_count in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<Long> values) {
            addCriterion("total_count not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(Long value1, Long value2) {
            addCriterion("total_count between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(Long value1, Long value2) {
            addCriterion("total_count not between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andPerCommissionIsNull() {
            addCriterion("per_commission is null");
            return (Criteria) this;
        }

        public Criteria andPerCommissionIsNotNull() {
            addCriterion("per_commission is not null");
            return (Criteria) this;
        }

        public Criteria andPerCommissionEqualTo(BigDecimal value) {
            addCriterion("per_commission =", value, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionNotEqualTo(BigDecimal value) {
            addCriterion("per_commission <>", value, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionGreaterThan(BigDecimal value) {
            addCriterion("per_commission >", value, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_commission >=", value, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionLessThan(BigDecimal value) {
            addCriterion("per_commission <", value, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_commission <=", value, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionIn(List<BigDecimal> values) {
            addCriterion("per_commission in", values, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionNotIn(List<BigDecimal> values) {
            addCriterion("per_commission not in", values, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_commission between", value1, value2, "perCommission");
            return (Criteria) this;
        }

        public Criteria andPerCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_commission not between", value1, value2, "perCommission");
            return (Criteria) this;
        }

        public Criteria andRestCountIsNull() {
            addCriterion("rest_count is null");
            return (Criteria) this;
        }

        public Criteria andRestCountIsNotNull() {
            addCriterion("rest_count is not null");
            return (Criteria) this;
        }

        public Criteria andRestCountEqualTo(Long value) {
            addCriterion("rest_count =", value, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountNotEqualTo(Long value) {
            addCriterion("rest_count <>", value, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountGreaterThan(Long value) {
            addCriterion("rest_count >", value, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountGreaterThanOrEqualTo(Long value) {
            addCriterion("rest_count >=", value, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountLessThan(Long value) {
            addCriterion("rest_count <", value, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountLessThanOrEqualTo(Long value) {
            addCriterion("rest_count <=", value, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountIn(List<Long> values) {
            addCriterion("rest_count in", values, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountNotIn(List<Long> values) {
            addCriterion("rest_count not in", values, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountBetween(Long value1, Long value2) {
            addCriterion("rest_count between", value1, value2, "restCount");
            return (Criteria) this;
        }

        public Criteria andRestCountNotBetween(Long value1, Long value2) {
            addCriterion("rest_count not between", value1, value2, "restCount");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNull() {
            addCriterion("expired_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNotNull() {
            addCriterion("expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeEqualTo(Date value) {
            addCriterion("expired_time =", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotEqualTo(Date value) {
            addCriterion("expired_time <>", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThan(Date value) {
            addCriterion("expired_time >", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expired_time >=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThan(Date value) {
            addCriterion("expired_time <", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThanOrEqualTo(Date value) {
            addCriterion("expired_time <=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIn(List<Date> values) {
            addCriterion("expired_time in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotIn(List<Date> values) {
            addCriterion("expired_time not in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeBetween(Date value1, Date value2) {
            addCriterion("expired_time between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotBetween(Date value1, Date value2) {
            addCriterion("expired_time not between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNull() {
            addCriterion("time_limit is null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNotNull() {
            addCriterion("time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitEqualTo(Integer value) {
            addCriterion("time_limit =", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotEqualTo(Integer value) {
            addCriterion("time_limit <>", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThan(Integer value) {
            addCriterion("time_limit >", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_limit >=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThan(Integer value) {
            addCriterion("time_limit <", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("time_limit <=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIn(List<Integer> values) {
            addCriterion("time_limit in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotIn(List<Integer> values) {
            addCriterion("time_limit not in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitBetween(Integer value1, Integer value2) {
            addCriterion("time_limit between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("time_limit not between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitIsNull() {
            addCriterion("per_count_limit is null");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitIsNotNull() {
            addCriterion("per_count_limit is not null");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitEqualTo(Integer value) {
            addCriterion("per_count_limit =", value, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitNotEqualTo(Integer value) {
            addCriterion("per_count_limit <>", value, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitGreaterThan(Integer value) {
            addCriterion("per_count_limit >", value, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("per_count_limit >=", value, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitLessThan(Integer value) {
            addCriterion("per_count_limit <", value, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitLessThanOrEqualTo(Integer value) {
            addCriterion("per_count_limit <=", value, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitIn(List<Integer> values) {
            addCriterion("per_count_limit in", values, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitNotIn(List<Integer> values) {
            addCriterion("per_count_limit not in", values, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitBetween(Integer value1, Integer value2) {
            addCriterion("per_count_limit between", value1, value2, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andPerCountLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("per_count_limit not between", value1, value2, "perCountLimit");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
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