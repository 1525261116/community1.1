package com.hhit.community.community.exception;

public enum SysErrorEnums implements IExceptionCode {
    /**参数为空*/
    EMPTY_PARAME("A11002","参数为空"),
    /**参数错误*/
    ERROR_PARAME("A11002","参数错误");
    private String errorCode;
    private String errorMessage;

    SysErrorEnums(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
