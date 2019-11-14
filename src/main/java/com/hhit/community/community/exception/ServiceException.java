package com.hhit.community.community.exception;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/10/16 17:26
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 145454578454844432L;
    IExceptionCode iExceptionCode;
    private String errorCode;
    private String errorMessage;
    public ServiceException(IExceptionCode iExceptionCode){
        super();
        this.iExceptionCode=iExceptionCode;
        this.errorCode = iExceptionCode.getErrorCode();
        this.errorMessage =iExceptionCode.getErrorCode();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
