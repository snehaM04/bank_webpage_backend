package com.example.onlineBankingSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="Customer")
public class Customer {


    @Id
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone_number",length = 10)
    private String phoneNumber;
    @Column(name="password",length = 15)
    private String password;
    @Column(name="address",columnDefinition = "text")
    private String address;
    public Customer()
    {
        //default constructor;
    }
    public Customer(Long customerId) {
        this.customerId = customerId;
    }
    public String getPassword() {
        return password;
    }
    public Long getcustomerId() {
        return customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setcustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

}
