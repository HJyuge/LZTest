package com.dazzlzy.springbootseed.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_user_bill")
public class UserBill{

    @Id
    private Double id;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /***
     * 账单id
     */
    @Column(name = "bill_id")
    private String billId;

    /**
     * 账单类型
     */
    @Column(name = "bill_type")
    private String billType;

    /**
     * 账单日期
     */
    @Column(name = "bill_date")
    private String billDate;
}
