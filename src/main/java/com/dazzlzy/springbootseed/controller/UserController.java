package com.dazzlzy.springbootseed.controller;

import com.dazzlzy.common.base.BaseResult;
import com.dazzlzy.springbootseed.model.user.User;
import com.dazzlzy.springbootseed.service.BillService;
import com.dazzlzy.springbootseed.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Api(value = "/user", tags = "用户信息模块")
@RestController
@RequestMapping(value = "/userOperation")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private BillService billService;

    @ApiOperation(value = "获取所有的用户信息")
    @PostMapping("/selectAllUserInfo")
    public BaseResult selectAllUserUserInfo(){
        return BaseResult.builder().success(true).code(200).data(userService.selectAllUserInfo()).build();
    }

    @ApiOperation(value = "根据用户昵称获取用户的信息")
    @PostMapping("/selectUserByNickname")
    public BaseResult selectUserByNickname(@RequestParam String nickname){
        return BaseResult.builder().success(true).code(200).data(userService.selectUserByNickname(nickname)).build();
    }

    @ApiOperation(value = "根据用户账号获取用户的信息")
    @PostMapping("/selectUserByAccount")
    public BaseResult selectUserByAccount(@RequestParam String account){
        return BaseResult.builder().success(true).code(200).data(userService.selectUserByAccount(account)).build();
    }

    @ApiOperation(value = "某天/某月/某年当前用户所有账单的信息")
    @PostMapping("/selectUserBillByAccount")
    public BaseResult selectUserBillByAccount(@RequestParam String userAccount,
                                              @RequestParam String billFormatDate,
                                              @RequestParam String dateSelectType){
       return billService.selectUserBill(userAccount, billFormatDate, dateSelectType);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/modifyUserInfo")
    public  int modifyUserInfo(@RequestBody User user){
        return  userService.modifyUserInfo(user);
    }
}
