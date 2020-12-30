package com.shenyf.shenyfwork.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IdiomRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IdiomRecordExample() {
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

        public Criteria andIdiomIdIsNull() {
            addCriterion("idiom_id is null");
            return (Criteria) this;
        }

        public Criteria andIdiomIdIsNotNull() {
            addCriterion("idiom_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomIdEqualTo(Long value) {
            addCriterion("idiom_id =", value, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdNotEqualTo(Long value) {
            addCriterion("idiom_id <>", value, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdGreaterThan(Long value) {
            addCriterion("idiom_id >", value, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("idiom_id >=", value, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdLessThan(Long value) {
            addCriterion("idiom_id <", value, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdLessThanOrEqualTo(Long value) {
            addCriterion("idiom_id <=", value, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdIn(List<Long> values) {
            addCriterion("idiom_id in", values, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdNotIn(List<Long> values) {
            addCriterion("idiom_id not in", values, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdBetween(Long value1, Long value2) {
            addCriterion("idiom_id between", value1, value2, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomIdNotBetween(Long value1, Long value2) {
            addCriterion("idiom_id not between", value1, value2, "idiomId");
            return (Criteria) this;
        }

        public Criteria andIdiomNameIsNull() {
            addCriterion("idiom_name is null");
            return (Criteria) this;
        }

        public Criteria andIdiomNameIsNotNull() {
            addCriterion("idiom_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomNameEqualTo(String value) {
            addCriterion("idiom_name =", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameNotEqualTo(String value) {
            addCriterion("idiom_name <>", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameGreaterThan(String value) {
            addCriterion("idiom_name >", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameGreaterThanOrEqualTo(String value) {
            addCriterion("idiom_name >=", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameLessThan(String value) {
            addCriterion("idiom_name <", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameLessThanOrEqualTo(String value) {
            addCriterion("idiom_name <=", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameLike(String value) {
            addCriterion("idiom_name like", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameNotLike(String value) {
            addCriterion("idiom_name not like", value, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameIn(List<String> values) {
            addCriterion("idiom_name in", values, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameNotIn(List<String> values) {
            addCriterion("idiom_name not in", values, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameBetween(String value1, String value2) {
            addCriterion("idiom_name between", value1, value2, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomNameNotBetween(String value1, String value2) {
            addCriterion("idiom_name not between", value1, value2, "idiomName");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceIsNull() {
            addCriterion("idiom_pronounce is null");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceIsNotNull() {
            addCriterion("idiom_pronounce is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceEqualTo(String value) {
            addCriterion("idiom_pronounce =", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceNotEqualTo(String value) {
            addCriterion("idiom_pronounce <>", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceGreaterThan(String value) {
            addCriterion("idiom_pronounce >", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceGreaterThanOrEqualTo(String value) {
            addCriterion("idiom_pronounce >=", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceLessThan(String value) {
            addCriterion("idiom_pronounce <", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceLessThanOrEqualTo(String value) {
            addCriterion("idiom_pronounce <=", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceLike(String value) {
            addCriterion("idiom_pronounce like", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceNotLike(String value) {
            addCriterion("idiom_pronounce not like", value, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceIn(List<String> values) {
            addCriterion("idiom_pronounce in", values, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceNotIn(List<String> values) {
            addCriterion("idiom_pronounce not in", values, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceBetween(String value1, String value2) {
            addCriterion("idiom_pronounce between", value1, value2, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomPronounceNotBetween(String value1, String value2) {
            addCriterion("idiom_pronounce not between", value1, value2, "idiomPronounce");
            return (Criteria) this;
        }

        public Criteria andIdiomContentIsNull() {
            addCriterion("idiom_content is null");
            return (Criteria) this;
        }

        public Criteria andIdiomContentIsNotNull() {
            addCriterion("idiom_content is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomContentEqualTo(String value) {
            addCriterion("idiom_content =", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentNotEqualTo(String value) {
            addCriterion("idiom_content <>", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentGreaterThan(String value) {
            addCriterion("idiom_content >", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentGreaterThanOrEqualTo(String value) {
            addCriterion("idiom_content >=", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentLessThan(String value) {
            addCriterion("idiom_content <", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentLessThanOrEqualTo(String value) {
            addCriterion("idiom_content <=", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentLike(String value) {
            addCriterion("idiom_content like", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentNotLike(String value) {
            addCriterion("idiom_content not like", value, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentIn(List<String> values) {
            addCriterion("idiom_content in", values, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentNotIn(List<String> values) {
            addCriterion("idiom_content not in", values, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentBetween(String value1, String value2) {
            addCriterion("idiom_content between", value1, value2, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomContentNotBetween(String value1, String value2) {
            addCriterion("idiom_content not between", value1, value2, "idiomContent");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromIsNull() {
            addCriterion("idiom_comefrom is null");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromIsNotNull() {
            addCriterion("idiom_comefrom is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromEqualTo(String value) {
            addCriterion("idiom_comefrom =", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromNotEqualTo(String value) {
            addCriterion("idiom_comefrom <>", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromGreaterThan(String value) {
            addCriterion("idiom_comefrom >", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromGreaterThanOrEqualTo(String value) {
            addCriterion("idiom_comefrom >=", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromLessThan(String value) {
            addCriterion("idiom_comefrom <", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromLessThanOrEqualTo(String value) {
            addCriterion("idiom_comefrom <=", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromLike(String value) {
            addCriterion("idiom_comefrom like", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromNotLike(String value) {
            addCriterion("idiom_comefrom not like", value, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromIn(List<String> values) {
            addCriterion("idiom_comefrom in", values, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromNotIn(List<String> values) {
            addCriterion("idiom_comefrom not in", values, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromBetween(String value1, String value2) {
            addCriterion("idiom_comefrom between", value1, value2, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomComefromNotBetween(String value1, String value2) {
            addCriterion("idiom_comefrom not between", value1, value2, "idiomComefrom");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymIsNull() {
            addCriterion("idiom_antonym is null");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymIsNotNull() {
            addCriterion("idiom_antonym is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymEqualTo(String value) {
            addCriterion("idiom_antonym =", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymNotEqualTo(String value) {
            addCriterion("idiom_antonym <>", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymGreaterThan(String value) {
            addCriterion("idiom_antonym >", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymGreaterThanOrEqualTo(String value) {
            addCriterion("idiom_antonym >=", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymLessThan(String value) {
            addCriterion("idiom_antonym <", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymLessThanOrEqualTo(String value) {
            addCriterion("idiom_antonym <=", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymLike(String value) {
            addCriterion("idiom_antonym like", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymNotLike(String value) {
            addCriterion("idiom_antonym not like", value, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymIn(List<String> values) {
            addCriterion("idiom_antonym in", values, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymNotIn(List<String> values) {
            addCriterion("idiom_antonym not in", values, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymBetween(String value1, String value2) {
            addCriterion("idiom_antonym between", value1, value2, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomAntonymNotBetween(String value1, String value2) {
            addCriterion("idiom_antonym not between", value1, value2, "idiomAntonym");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusIsNull() {
            addCriterion("idiom_thesaurus is null");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusIsNotNull() {
            addCriterion("idiom_thesaurus is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusEqualTo(String value) {
            addCriterion("idiom_thesaurus =", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusNotEqualTo(String value) {
            addCriterion("idiom_thesaurus <>", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusGreaterThan(String value) {
            addCriterion("idiom_thesaurus >", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusGreaterThanOrEqualTo(String value) {
            addCriterion("idiom_thesaurus >=", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusLessThan(String value) {
            addCriterion("idiom_thesaurus <", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusLessThanOrEqualTo(String value) {
            addCriterion("idiom_thesaurus <=", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusLike(String value) {
            addCriterion("idiom_thesaurus like", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusNotLike(String value) {
            addCriterion("idiom_thesaurus not like", value, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusIn(List<String> values) {
            addCriterion("idiom_thesaurus in", values, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusNotIn(List<String> values) {
            addCriterion("idiom_thesaurus not in", values, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusBetween(String value1, String value2) {
            addCriterion("idiom_thesaurus between", value1, value2, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomThesaurusNotBetween(String value1, String value2) {
            addCriterion("idiom_thesaurus not between", value1, value2, "idiomThesaurus");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleIsNull() {
            addCriterion("idiom_example is null");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleIsNotNull() {
            addCriterion("idiom_example is not null");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleEqualTo(String value) {
            addCriterion("idiom_example =", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleNotEqualTo(String value) {
            addCriterion("idiom_example <>", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleGreaterThan(String value) {
            addCriterion("idiom_example >", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleGreaterThanOrEqualTo(String value) {
            addCriterion("idiom_example >=", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleLessThan(String value) {
            addCriterion("idiom_example <", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleLessThanOrEqualTo(String value) {
            addCriterion("idiom_example <=", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleLike(String value) {
            addCriterion("idiom_example like", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleNotLike(String value) {
            addCriterion("idiom_example not like", value, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleIn(List<String> values) {
            addCriterion("idiom_example in", values, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleNotIn(List<String> values) {
            addCriterion("idiom_example not in", values, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleBetween(String value1, String value2) {
            addCriterion("idiom_example between", value1, value2, "idiomExample");
            return (Criteria) this;
        }

        public Criteria andIdiomExampleNotBetween(String value1, String value2) {
            addCriterion("idiom_example not between", value1, value2, "idiomExample");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andValue1IsNull() {
            addCriterion("value1 is null");
            return (Criteria) this;
        }

        public Criteria andValue1IsNotNull() {
            addCriterion("value1 is not null");
            return (Criteria) this;
        }

        public Criteria andValue1EqualTo(String value) {
            addCriterion("value1 =", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotEqualTo(String value) {
            addCriterion("value1 <>", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThan(String value) {
            addCriterion("value1 >", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThanOrEqualTo(String value) {
            addCriterion("value1 >=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThan(String value) {
            addCriterion("value1 <", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThanOrEqualTo(String value) {
            addCriterion("value1 <=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Like(String value) {
            addCriterion("value1 like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotLike(String value) {
            addCriterion("value1 not like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1In(List<String> values) {
            addCriterion("value1 in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotIn(List<String> values) {
            addCriterion("value1 not in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Between(String value1, String value2) {
            addCriterion("value1 between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotBetween(String value1, String value2) {
            addCriterion("value1 not between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue2IsNull() {
            addCriterion("value2 is null");
            return (Criteria) this;
        }

        public Criteria andValue2IsNotNull() {
            addCriterion("value2 is not null");
            return (Criteria) this;
        }

        public Criteria andValue2EqualTo(String value) {
            addCriterion("value2 =", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotEqualTo(String value) {
            addCriterion("value2 <>", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThan(String value) {
            addCriterion("value2 >", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThanOrEqualTo(String value) {
            addCriterion("value2 >=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThan(String value) {
            addCriterion("value2 <", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThanOrEqualTo(String value) {
            addCriterion("value2 <=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2Like(String value) {
            addCriterion("value2 like", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotLike(String value) {
            addCriterion("value2 not like", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2In(List<String> values) {
            addCriterion("value2 in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotIn(List<String> values) {
            addCriterion("value2 not in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2Between(String value1, String value2) {
            addCriterion("value2 between", value1, value2, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotBetween(String value1, String value2) {
            addCriterion("value2 not between", value1, value2, "value2");
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