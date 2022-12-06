package com.example.courseWork.Database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "transactions_cut")
public class BankTransaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trans_id")
    private long transID;

    @Column(name = "customer_id")
    private long customerId;

    @Column (name = "tr_datetime")
    private String trDatetime;

    @Column (name = "mcc_code")
    private long mccCode;

    @Column (name = "tr_type")
    private long trType;

    @Column (name = "amount")
    private double amount;

    @Column (name = "term_id")
    private String termId;

    public BankTransaction(long transID, long customerId, String trDatetime, long mccCode, long trType, double amount, String termId) {
        this.transID = transID;
        this.customerId = customerId;
        this.trDatetime = trDatetime;
        this.mccCode = mccCode;
        this.trType = trType;
        this.amount = amount;
        this.termId = termId;
    }

    public BankTransaction() {
    }

    @Override
    public String toString() {
        return "Transactions { " +
                "customer_id = " + customerId +
                ", tr_datetime = '" + trDatetime + '\'' +
                ", mcc_code = " + mccCode +
                ", tr_type = " + trType +
                ", amount = " + amount +
                ", term_id = '" + termId + '\'' +
                '}';
    }

    public long getTrans_id() {
        return transID;
    }

    public long getCustomer_id() {
        return customerId;
    }
    public void setCustomer_id(long customer_id) {
        this.customerId = customer_id;
    }

    public void setTr_datetime(String tr_datetime) {
        this.trDatetime = tr_datetime;
    }
    public String getTr_datetime() {
        return trDatetime ;
    }

    public long getMcc_code() {
        return mccCode;
    }
    public void setMcc_code(long mcc_code) {
        this.mccCode = mcc_code;
    }

    public long getTr_type() {
        return trType;
    }
    public void setTr_type(long tr_type) {
        this.trType = tr_type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }

    public void setTerm_id(String term_id) {
        this.termId = term_id;
    }
    public String getTerm_id() {
        return termId;
    }

}
