package com.dazzlzy.springbootseed.service;

import com.dazzlzy.common.base.BaseResult;


public interface BillService {

    BaseResult selectUserBill(String userAccount, String billFormatDate, String dateSelectType);
}
