package com.dazzlzy.springbootseed.service.impl;

import com.dazzlzy.common.base.BaseResult;
import com.dazzlzy.springbootseed.dao.user.BillMapper;
import com.dazzlzy.springbootseed.model.user.UserBill;
import com.dazzlzy.springbootseed.service.BillService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Service("BillService")
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper billMapper;

    @Override
    public BaseResult selectUserBill(String userAccount, String billFormatDate, String dateSelectType){
        List<String> dates = Arrays.asList("day","month","year");
        List<UserBill> userBills;
        if (dates.contains(dateSelectType)){
            userBills = billMapper.selectUserBillInfo(userAccount,billFormatDate,dateSelectType);
            return BaseResult.builder().success(true).code(200).data(userBills).build();
        }else {
            log.info("dateSelectType = " + dateSelectType +" exceptionReason :参数异常");
            return BaseResult.builder().success(false).code(500).message("dateSelectType参数异常").build();
        }
    }


}
