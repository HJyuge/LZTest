package com.dazzlzy.springbootseed.dao.user;

import com.dazzlzy.common.base.BaseMapper;
import com.dazzlzy.springbootseed.model.user.User;
import com.dazzlzy.springbootseed.model.user.UserBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Mapper
 *
 * @author dazzlzy
 * @date 2018/5/19
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据条件查询用户集合
     *
     * @param user 查询条件
     * @return 用户集合
     */
    List<User> selectUser(@Param("user") User user);

    /**
     * 根据用户ID或者用户名称查询用户
     *
     * @param id   用户ID
     * @param name 用户名
     * @return 一个用户
     */
    User selectUserByIdOrName(@Param("id") Long id, @Param("name") String name);

    /**
     * 根据用户ID集合查询用户集合
     *
     * @param ids 用户ID集合
     * @return 用户集合
     */
    List<User> selectUserByIds(@Param("ids") List<Long> ids);

    /**下面是项目需要的mapper接口**/

    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> selectAllUserInfo();

    /**
     * 根据昵称查询用户信息
     * @param nickname
     * @return
     */
    User selectUserByNickname(@Param("nickname") String nickname);

    /**
     * 根据用户账号查询用户信息
     * @param account
     * @return
     */
    User selectUserByAccount(@Param("account") String account);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int modifyUserInfo(@Param("user") User user);

}