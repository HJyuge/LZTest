package com.dazzlzy.springbootseed.service.impl;

import com.dazzlzy.common.base.BaseResult;
import com.dazzlzy.springbootseed.dao.user.BillMapper;
import com.dazzlzy.springbootseed.model.user.Bill;
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
        List<Bill> userBills;
        if (dates.contains(dateSelectType)){
            userBills = billMapper.selectUserBillInfo(userAccount,billFormatDate,dateSelectType);
            return BaseResult.builder().success(true).code(200).data(userBills).build();
        }else {
            log.info("dateSelectType = " + dateSelectType +" exceptionReason :参数异常");
            return BaseResult.builder().success(false).code(500).message("dateSelectType参数异常").build();
        }
    }

    @Override
    public BaseResult insertUserBill(Bill bill) {
        Integer success = billMapper.insertUserBill(bill);
        if (success == 1){
            return BaseResult.builder().success(true).code(200).build();
        }else {
            log.info("bill = " + bill +" exceptionReason :参数异常/sql操作字段异常");
            return BaseResult.builder().success(false).code(500).message("参数异常").build();
        }
    }

    @Override
    public BaseResult updateBillInfo(Bill bill) {
        Integer success = billMapper.updateBillInfo(bill);
        if (success == 1) {
            return BaseResult.builder().success(true).code(200).build();
        }else {
            log.info("bill = " + bill +" exceptionReason :参数异常/sql操作字段异常");
            return BaseResult.builder().success(false).code(500).message("参数异常").build();
        }
    }

    @Override
    public BaseResult deleteBillById(String billId) {
        Integer success = billMapper.deleteBillById(billId);
        if (success == 1) {
            return BaseResult.builder().success(true).code(200).build();
        }else {
            log.info("billId = " + billId +" exceptionReason :参数异常/sql操作字段异常");
            return BaseResult.builder().success(false).code(500).message("参数异常").build();
        }
    }

    @Override
    public BaseResult selectBillsByAccount(String account) {

        if (account != null){
            List<Bill> bills = billMapper.selectBillsByAccount(account);
            return  BaseResult.builder().success(true).code(200).data(bills).message("请求成功").build();
        }else {
            log.info("account is null. exceptionReason :参数异常/sql操作字段异常");
            return BaseResult.builder().success(false).code(500).message("参数异常").build();
        }
    }
}
