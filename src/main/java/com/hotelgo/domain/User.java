package com.hotelgo.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    @NotNull
    private String email;

    public User(){};

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    private List<Transaction> transactions;

//
//    @Column(name = "password")
//    private String password;


//    @Column(name = "confirm_password")
//    private String confirmPassword;
//
//
//    @Column(name = "confirm_token")
//    private String confirmToken;
//
//    @NotNull
//    @CreationTimestamp
//    @Column(name="create_at")
//    private Instant createdAt = Instant.now();
//
//    @UpdateTimestamp
//    @Column(name="update_at")
//    private Instant updateAt;
//
//    @Column(name="last_login_at")
//    private Instant lastLoginAt;
//
//
//    @Column(name = "last_reset_at")
//    private Instant lastResetAt;
//
//
//    @Column(name = "confirm_at")
//    private Instant confirmAt;
//
//    @NotNull
//
//    @Column(name = "confirm_status")
//    private Integer confirmStatus;
//
//    @Column
//    private String timezone;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    //    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//
//    public String getConfirmToken() {
//        return confirmToken;
//    }
//
//    public void setConfirmToken(String confirmToken) {
//        this.confirmToken = confirmToken;
//    }
//
//    public Instant getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Instant createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Instant getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(Instant updateAt) {
//        this.updateAt = updateAt;
//    }
//
//    public Instant getLastLoginAt() {
//        return lastLoginAt;
//    }
//
//    public void setLastLoginAt(Instant lastLoginAt) {
//        this.lastLoginAt = lastLoginAt;
//    }
//
//    public Instant getLastResetAt() {
//        return lastResetAt;
//    }
//
//    public void setLastResetAt(Instant lastResetAt) {
//        this.lastResetAt = lastResetAt;
//    }
//
//    public Instant getConfirmAt() {
//        return confirmAt;
//    }
//
//    public void setConfirmAt(Instant confirmAt) {
//        this.confirmAt = confirmAt;
//    }
//
//    public Integer getConfirmStatus() {
//        return confirmStatus;
//    }
//
//    public void setConfirmStatus(Integer confirmStatus) {
//        this.confirmStatus = confirmStatus;
//    }
//
//    public String getTimezone() {
//        return timezone;
//    }
//
//    public void setTimezone(String timezone) {
//        this.timezone = timezone;
//    }
}