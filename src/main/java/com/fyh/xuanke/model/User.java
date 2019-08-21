package com.fyh.xuanke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "username")
    @NotBlank(message="用户名不能为空")
    private String username;


    @Column(name = "password", nullable = false)
    @NotBlank(message="密码不能为空")
    private String password;


    @Column(name = "id", nullable = false)
    private long id;


    @Column(name="dbflag")
    private String dbflag;

    public String getDbflag() {
        return dbflag;
    }

    public void setDbflag(String dbflag) {
        this.dbflag = dbflag;
    }

    //    @Column(name = "repassword", nullable = false)
    private String repassword;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
