package com.company.budget2.entity.demand;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;

@Table(name = "BUDGET2_TOPIC")
@Entity(name = "budget2_Topic")
@NamePattern("%s|name")
public class Topic extends BaseUuidEntity {
    private static final long serialVersionUID = -7847125122724338437L;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @OnDeleteInverse(DeletePolicy.DENY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IPRB_ID")
    private IPRB iprb;

    @Column(name = "NAME")
    private String name;

    @Column(name = "Q1")
    private Integer q1;

    @Column(name = "Q2")
    private Integer q2;

    @Column(name = "Q3")
    private Integer q3;

    @Column(name = "Q4")
    private Integer q4;

    public Integer getQ1() {
        return q1==null ? 0 : q1;
    }

    public void setQ1(Integer q1) {
        this.q1 = q1;
    }

    public void setQ2(Integer q2) {
        this.q2 = q2;
    }

    public Integer getQ2() {
        return q2==null ? 0 : q2;
    }

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

    public String getName() {
        return name==null ? "":name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IPRB getIprb() {
        return iprb;
    }

    public void setIprb(IPRB iprb) {
        this.iprb = iprb;
    }
}