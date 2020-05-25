package com.waectr.wetec.dao;

import com.github.pagehelper.Page;
import com.waectr.wetec.dataobject.UserDO;

public interface UserDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon May 25 16:12:04 CST 2020
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon May 25 16:12:04 CST 2020
     */
    int insert(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon May 25 16:12:04 CST 2020
     */
    int insertSelective(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon May 25 16:12:04 CST 2020
     */
    UserDO selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon May 25 16:12:04 CST 2020
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon May 25 16:12:04 CST 2020
     */
    int updateByPrimaryKey(UserDO record);

    UserDO selectByEmail(String email);

    //根据email来修改用户状态
    int updateStatusByEmail(String email,Integer status);

    Page<UserDO> getUserList();
}