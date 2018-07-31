package com.hotelgo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="transactions")

public class Transaction {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="transactions_id_seq")
    @SequenceGenerator(name="transactions_id_seq", sequenceName="transactions_id_seq", allocationSize=1)
    private Long id;


    @Column(name="tran_no",unique = true)
    @NotNull
    private int tranNo;


    @Column(name="user_id")
    @NotNull
    private String userId;


    @Column(name = "start_date")
    private String startDate;


    @Column(name = "end_date")
    private String endDate;


    @Column(name = "total_payment")
    private int totalPayment;


    @Column(name = "payment_type")
    private String paymentType;

    public Long getId() {
        return id;
    }

    public int getTranNo() {
        return tranNo;
    }

    public void setTranNo(int tranNo) {
        this.tranNo = tranNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
