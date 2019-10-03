package com.caseStudy.eCart.model;

import javax.persistence.Entity;

@Entity
public class Users {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String mobileNo;
    private Gender gender;
}
