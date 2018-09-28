package com.hotelgo.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="users")
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="users_id_seq")
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    private Long id;

    @Column(unique = true)
    @JsonView({JsView.Other.class})
    private String username;

    @Column(name = "first_name")
    @JsonView({JsView.Other.class})
    private String firstName;

    @Column(name = "last_name")
    @JsonView({JsView.Other.class})
    private String lastName;

    @Column(unique = true)
    @NotNull
    @JsonView({JsView.User.class})
    private String email;

    public User(){};

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Transaction> transactions;

    @Column(name = "password")
    @NotNull
    @JsonIgnore
    public String password;

    @Column(name = "account_expired")
    @JsonIgnore
    public Boolean accountExpire=Boolean.FALSE;


    @Column(name = "credential_expired")
    @JsonIgnore
    public Boolean credentialsexpired=Boolean.FALSE;

    @Column(name="enabled")
    @JsonIgnore
    public Boolean enabled=Boolean.TRUE;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;






    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpire;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsexpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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

//    public List<Transaction> getTransactions() {
//        return transactions;
//    }

//    public void setTransactions(List<Transaction> transactions) {
//        this.transactions = transactions;
//    }

    public Boolean getAccountExpire() {
        return accountExpire;
    }

    public void setAccountExpire(Boolean accountExpire) {
        this.accountExpire = accountExpire;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}