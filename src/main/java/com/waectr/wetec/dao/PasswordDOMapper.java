package com.waectr.wetec.dao;

import com.waectr.wetec.dataobject.PasswordDO;

public interface PasswordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_password
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    int deleteByPrimaryKey(Integer passwordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_password
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    int insert(PasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_password
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    int insertSelective(PasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_password
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    PasswordDO selectByPrimaryKey(Integer passwordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_password
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    int updateByPrimaryKeySelective(PasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_password
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    int updateByPrimaryKey(PasswordDO record);
}