package com.dazzlzy.springbootseed.service;

import com.dazzlzy.common.base.BaseResult;
import com.dazzlzy.springbootseed.model.user.Bill;


public interface BillService {

    BaseResult selectUserBill(String userAccount, String billFormatDate, String dateSelectType);

    BaseResult insertUserBill(Bill bill);

    BaseResult updateBillInfo(Bill bill);
}
