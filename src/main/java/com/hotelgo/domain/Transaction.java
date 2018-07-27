//package com.hotelgo.domain;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//@Entity
//@Table(name="transaction_record")
//
//public class Transaction {
//
//    @javax.persistence.Id
//    @GeneratedValue(strategy=SEQUENCE, generator="transaction_id_seq")
//    @SequenceGenerator(name="transaction_id_seq", sequenceName="transaction_id_seq", allocationSize=1)
//    private String Id;
//
//
//    @Column(unique = true)
//    @NotNull
//    private int Tran_No;
//
//
//    @Column(unique = true)
//    @NotNull
//    private String User_Id;
//
//
//    @Column(name = "Start_Date")
//    private String Start_Date;
//
//
//    @Column(name = "End_Date")
//    private String End_Date;
//
//
//    @Column(name = "Total_Payment")
//    private String Total_Payment;
//
//
//    @Column(name = "Payment_Type")
//    private String Payment_Type;
//
//
//    public String getId() {
//        return Id;
//    }
//
//
//    public int getTran_No() {
//        return Tran_No;
//    }
//
//    public void setTran_No(int tran_No) {
//        Tran_No = tran_No;
//    }
//
//    public String getStart_Date() {
//        return Start_Date;
//    }
//
//    public void setStart_Date(String start_Date) {
//        Start_Date = start_Date;
//    }
//
//    public String getEnd_Date() {
//        return End_Date;
//    }
//
//    public void setEnd_Date(String end_Date) {
//        End_Date = end_Date;
//    }
//
//    public String getTotal_Payment() {
//        return Total_Payment;
//    }
//
//    public void setTotal_Payment(String total_Payment) {
//        Total_Payment = total_Payment;
//    }
//
//
//    public String getPayment_Type() {
//        return Payment_Type;
//    }
//
//
//    public void setPayment_Type(String payment_Type) {
//        Payment_Type = payment_Type;
//    }
//
//
//    public String getUser_Id() {
//        return User_Id;
//    }
//
//    public void setUser_Id(String user_Id) {
//        User_Id = user_Id;
//    }
//}
