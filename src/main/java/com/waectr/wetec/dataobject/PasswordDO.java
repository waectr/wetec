package com.waectr.wetec.dataobject;

public class PasswordDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_password.password_id
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    private Integer passwordId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_password.password_context
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    private String passwordContext;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_password.password_id
     *
     * @return the value of t_password.password_id
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    public Integer getPasswordId() {
        return passwordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_password.password_id
     *
     * @param passwordId the value for t_password.password_id
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    public void setPasswordId(Integer passwordId) {
        this.passwordId = passwordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_password.password_context
     *
     * @return the value of t_password.password_context
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    public String getPasswordContext() {
        return passwordContext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_password.password_context
     *
     * @param passwordContext the value for t_password.password_context
     *
     * @mbg.generated Sun May 24 17:24:53 CST 2020
     */
    public void setPasswordContext(String passwordContext) {
        this.passwordContext = passwordContext == null ? null : passwordContext.trim();
    }
}