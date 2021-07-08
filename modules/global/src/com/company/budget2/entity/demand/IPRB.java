package com.company.budget2.entity.demand;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "BUDGET2_IPRB")
@Entity(name = "budget2_IPRB")
@NamePattern("%s|icTag")
public class IPRB extends BaseUuidEntity {
    private static final long serialVersionUID = 5176354470858641229L;

    @Column(name = "IC_TAG")
    private String icTag;

    @Column(name = "Q1")
    private Integer q1;

    @Column(name = "Q2")
    private Integer q2;

    @Column(name = "Q3")
    private Integer q3;

    @Column(name = "Q4")
    private Integer q4;

    public Integer getQ4() {
        return q4==null ? 0 : q4;
    }

    public void setQ4(Integer q4) {
        this.q4 = q4;
    }

    public Integer getQ3() {
        return q3==null ? 0 : q3;
    }

    public void setQ3(Integer q3) {
        this.q3 = q3;
    }

    public void setQ2(Integer q2) {
        this.q2 = q2;
    }

    public Integer getQ2() {
        return q2==null ? 0 : q2;
    }

    public Integer getQ1() {
        return q1==null ? 0 : q1;
    }

    public void setQ1(Integer q1) {
        this.q1 = q1;
    }

    public String getIcTag() {
        return icTag==null ? "" : icTag;
    }

    public void setIcTag(String icTag) {
        this.icTag = icTag;
    }
}