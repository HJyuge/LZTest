package com.dazzlzy.springbootseed.dao.user;

import com.dazzlzy.springbootseed.model.user.Bill;
import com.dazzlzy.springbootseed.model.user.UserBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {

    /**
     * 某天/某月/某年当前用户所有账单的信息
     * @param userAccount
     * @return
     */
    List<UserBill> selectUserBillInfo(@Param("userAccount") String userAccount,
                                      @Param("billFormatDate") String billFormatDate,
                                      @Param("dateSelectType") String dateSelectType);

    int insertUserBill(@Param("bill") Bill bill);

    int updateBillInfo(@Param("bill") Bill bill);
}
