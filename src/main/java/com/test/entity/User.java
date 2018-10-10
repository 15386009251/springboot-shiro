package com.test.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {

    private int uid;
    private String username;
    private String password;
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(int uid, String username) {
        this.uid = uid;
        this.username = username;
    }

    @Id
    @GeneratedValue
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "uid", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "rid", referencedColumnName = "rid")}
    )
    @ManyToMany
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
