package com.combs.dashboard.user;

import java.time.LocalDate;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {
    
    @PrimaryKey private String userId;
    private String fName;
    private String lName;
    private String imageUrl;
    private LocalDate birthdate;

    public User() {
    }

    public User(String userId, String fName, String lName, String imageUrl, LocalDate birthdate) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.imageUrl = imageUrl;
        this.birthdate = birthdate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    
}
