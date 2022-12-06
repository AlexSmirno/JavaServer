package com.example.courseWork.Database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "tr_mcc_codes")
public class MccCode
{
    @Id
    private long mccCode;

    @Column(name = "mcc_description")
    private String mccDescription;

    public MccCode() {
    }

    public MccCode(long mccCode, String mccDescription) {
        this.mccCode = mccCode;
        this.mccDescription = mccDescription;
    }


    public String getMcc_description() {
        return mccDescription;
    }

    public void setMcc_description(String mcc_description) {
        this.mccDescription = mcc_description;
    }

    public Long getMcc_code() {
        return mccCode;
    }

    public void setMcc_code(Long mcc_code) {
        this.mccCode = mcc_code;
    }

    @Override
    public String toString() {
        return "tr_mcc_codes{" +
                "mcc_code=" + mccCode +
                ", mcc_description='" + mccDescription + '\'' +
                '}';
    }
}
