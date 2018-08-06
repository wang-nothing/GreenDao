package com.example.admin.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class UserBean {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    @Generated(hash = 2024802960)
    public UserBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
