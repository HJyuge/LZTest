package com.dazzlzy.springbootseed.model.user;

import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * 用户
 *
 * @author dazzlzy
 * @date 2018/5/19
 */
@Data
@Table(name = "t_user")
public class User {

    /**
     * 用户账号
     */
    @Id
    private String account;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 启用状态
     */
    @Column(name = "state_code")
    private Integer stateCode;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * Email
     */
    private String email;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 性别
     */
    @Column(name = "sex")
    private boolean sex;

    /**
     * 年纪
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 用户图像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 个性签名
     */
    @Column(name = "signature")
    private String signature;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 角色列表
     */
    @Transient
    private List<Role> roles;

    /**
     * 权限列表
     */
    @Transient
    private List<Permission> permissions;

}