package com.basket.basketproject.exception;

import com.basket.basketproject.constant.ExceptionConst;
import com.basket.basketproject.result.GlobalResultErrorInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 异常记入报警系统
 * @Author shaoyonggong
 * @Date 2020/6/14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommonException extends RuntimeException {

    public CommonException(String message) {
        this.errorCode = ExceptionConst.REJECT_ERROR_CODE;
        this.message = message;
    }

    public CommonException(String code, String message) {
        this.errorCode = code;
        this.message = message;
    }

    public CommonException(String code, String message, List<String> messageStacks) {
        this.errorCode = code;
        this.message = message;
        if (messageStacks != null) {
            this.messageStacks = messageStacks;
        }
        this.messageStacks.add(0, message);
    }

    public CommonException(String code, String message, Throwable t) {
        this.errorCode = code;
        this.message = message;
        if (t != null) {
            this.errorStacks = ExceptionUtils.getStackTrace(t);
        }
    }

    public CommonException(GlobalResultErrorInfo globalResultErrorInfo) {
        if (globalResultErrorInfo.getMessageStacks() != null) {
            this.messageStacks = globalResultErrorInfo.getMessageStacks();
        }
    }

    public CommonException(String message, GlobalResultErrorInfo globalResultErrorInfo) {
        if (globalResultErrorInfo.getMessageStacks() != null) {
            this.messageStacks = globalResultErrorInfo.getMessageStacks();
        }
    }

    public CommonException(String message, Throwable t) {
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
}
