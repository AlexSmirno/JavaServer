package com.example.courseWork.Database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "gender_train_cut")
public class GenderTrain
{
    @Id
    @Column(name = "customer_id")
    private long customerID;

    @Column(name = "gender")
    private byte gender;

    public GenderTrain()
    {

    }

    public GenderTrain(long customer_id, byte gender)
    {
        this.customerID = customer_id;
        this.gender = gender;
    }


    public long getCustomer_id() {
        return customerID;
    }

    public void setCustomer_id(long customer_id) {
        this.customerID = customer_id;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "gender_train{" +
                "customer_id=" + customerID +
                ", gender=" + gender +
                '}';
    }
}
