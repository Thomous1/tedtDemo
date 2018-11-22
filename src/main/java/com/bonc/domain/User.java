package com.bonc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 王小浪 on 2018/6/4.
 * CREATE TABLE `u_user` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
 `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
 `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
 `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

 */
public class User implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private Integer id;
    private String nickname;
    private String pswd;
    private String email;
    private Date create_time;
    private Date last_login_time;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
