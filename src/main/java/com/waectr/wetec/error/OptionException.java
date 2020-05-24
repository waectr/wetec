package com.waectr.wetec.error;

public class OptionException extends Exception implements CommonError{
    private CommonError commonError;

    //接收EmBussinessError的传参用于构造业务异常
    public OptionException(CommonError commonError){
        super();
        this.commonError=commonError;
    }


    //接收errMsg的方式构造业务异常
    public OptionException(CommonError commonError,String errMsg){
        super();
        this.commonError=commonError;
        this.commonError.setErrMsg(errMsg);
    }


    @Override
    public int getErrCode() {
        return commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.setErrMsg(errMsg);
        return this;
    }
}
