package com.basket.basketproject.exception;

import com.basket.basketproject.constant.ExceptionConst;
import com.basket.basketproject.result.GlobalResultErrorInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 运行时异常类
 * @Author shaoyonggong
 * @Date 2020/6/14
 */
public class ServeRejectException extends Exception {

    private static final long serialVersionUID = 4453214753962022203L;

    public ServeRejectException(String message) {
        super(message);
        this.errorCode = ExceptionConst.REJECT_ERROR_CODE;
        this.message = message;
    }

    public ServeRejectException(String code, String message) {
        super(message);
        this.errorCode = ExceptionConst.REJECT_ERROR_CODE;
        this.message = message;
    }

    public ServeRejectException(String code, String message, List<String> messageStacks) {
        super(message);
        this.errorCode = code;
        this.message = message;
        if (messageStacks != null) {
            this.messageStacks = messageStacks;
        }
        this.messageStacks.add(0, message);
    }

    public ServeRejectException(String code, String message, Throwable t) {
        super(message, t);
        this.errorCode = ExceptionConst.REJECT_ERROR_CODE;
        this.message = message;
        if (t != null) {
            this.errorStacks = ExceptionUtils.getStackTrace(t);
        }
    }

    public ServeRejectException(GlobalResultErrorInfo ifmResultErrorInfo) {
        super("");
        if (ifmResultErrorInfo.getMessageStacks() != null) {
            this.messageStacks = ifmResultErrorInfo.getMessageStacks();
        }
    }

    public ServeRejectException(String message, GlobalResultErrorInfo ifmResultErrorInfo) {
        super(message);
        if (ifmResultErrorInfo.getMessageStacks() != null) {
            this.messageStacks = ifmResultErrorInfo.getMessageStacks();
        }
    }

    public ServeRejectException(String message, Throwable t) {
        super(message, t);
        this.errorCode = ExceptionConst.REJECT_ERROR_CODE;
        this.message = message;
        if (t != null) {
            this.errorStacks = ExceptionUtils.getStackTrace(t);
        }
    }

    /**
     * 异常编码
     */
    @ApiModelProperty(value = "异常编码", name = "异常编码", example = "0")
    private String errorCode;

    /**
     * 未知错误
     */
    @ApiModelProperty(value = "简述", name = "简述", example = "订单下单的处理失败")
    private String message = null;

    /**
     * 异常堆栈
     */
    @ApiModelProperty(value = "异常堆栈", name = "异常堆栈", example = "")
    private String errorStacks = null;

    /**
     * 跟踪异常信息
     */
    @ApiModelProperty(value = "跟踪异常信息", name = "跟踪异常信息", example = "")
    private List<String> messageStacks = new ArrayList<>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorStacks() {
        return errorStacks;
    }

    public void setErrorStacks(String errorStacks) {
        this.errorStacks = errorStacks;
    }

    public List<String> getMessageStacks() {
        return messageStacks;
    }

    public void setMessageStacks(List<String> messageStacks) {
        this.messageStacks = messageStacks;
    }
}
