package com.dazzlzy.springbootseed.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_bill")
public class Bill {

    /***
     * 账单id
     */
    @Id
    @Column(name = "bill_id")
    private Double billId;

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

    /**
     * 流水类型
     */
    @Column(name = "statement")
    private String statement;

    /**
     * 支出，收入
     */
    @Column(name = "sign")
    private String sign;

    /**
     * 金额
     */
    @Column(name = "money")
    private Double money;

    /**
     * 更新日期
     */
    @Column(name = "modify_date")
    private String modifyDate;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
