package com.test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    private int rid;
    private String rname;
    private List<User> users = new ArrayList<>();
    private List<Module> modules = new ArrayList<>();

    @Id
    @GeneratedValue
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @JoinTable(name = "module_role",
            joinColumns = {@JoinColumn(name = "rid", referencedColumnName = "rid")},
            inverseJoinColumns = {@JoinColumn(name = "mid", referencedColumnName = "mid")}
    )
    @ManyToMany
    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @ManyToMany(mappedBy = "roles")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
