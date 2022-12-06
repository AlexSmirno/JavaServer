package com.example.courseWork.Database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "tr_types")
public class TranType
{
    @Id
    @Column(name = "tr_types")
    private long typeId;

    @Column(name = "tr_description")
    private String description;

    public TranType() {
    }

    public TranType(long tr_type, String tr_description) {
        this.typeId = tr_type;
        this.description = tr_description;
    }

    public Long getTr_type() {
        return typeId;
    }

    public void setTr_type(Long tr_type) {
        this.typeId = tr_type;
    }

    public String getTr_description() {
        return description;
    }

    public void setTr_description(String tr_description) {
        this.description = tr_description;
    }

    @Override
    public String toString() {
        return "tr_types{" +
                "tr_type=" + typeId +
                ", tr_description='" + description + '\'' +
                '}';
    }
}
