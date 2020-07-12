package com.basket.basketproject.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 返回值处理类
 * @Author shaoyonggong
 * @Date 2020/7/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalResult<D> {

    public GlobalResult() {
    }

    public void merge(GlobalResult<D> globalResult) {
        this.status = globalResult.status;
        this.code = globalResult.code;
        this.body = globalResult.body;
        this.message = globalResult.message;
        this.validationErrors.addAll(globalResult.validationErrors);
        this.exception = globalResult.exception;
        this.totalCount = globalResult.totalCount;
    }

    public enum status_enum {
        SUCCESS,
        REFUSED,
        FAILED
    }

    /**
     * 状态码 成功201 拒绝203 失败205
     */
    public static final Integer SUCCESS_CODE = 201;
    public static final Integer REFUSED_CODE = 203;
    public static final Integer FAILED_CODE = 205;

    /**
     * 状态码
     */
    private Integer code = SUCCESS_CODE;

    /**
     * 状态
     */
    private status_enum status = status_enum.SUCCESS;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 异常
     */
    private GlobalResultErrorInfo exception = null;

    /**
     * 主体
     */
    private D body;

    /**
     * 验证错误
     */
    private List<VaildateFieldError> validationErrors = new ArrayList<>();

    /**
     * 总数
     */
    private int totalCount;

    /**
     * 原始参数
     */
    private Object originalParam;

    /**
     * 标记服务成功
     */
    public void markSuccess() {
        this.code = SUCCESS_CODE;
        this.status = status_enum.SUCCESS;
    }

    /**
     * 标记服务成功
     */
    public void markSuccess(String message) {
        this.code = SUCCESS_CODE;
        this.status = status_enum.SUCCESS;
        this.message = message;
    }

    /**
     * 标记服务拒绝处理(由于验证失败等原因.)
     */
    public void markRefused() {
        this.code = REFUSED_CODE;
        this.status = status_enum.REFUSED;
    }

    /**
     * 标记服务拒绝处理(由于验证失败等原因.)
     */
    public void markRefused(String message) {
        this.code = REFUSED_CODE;
        this.status = status_enum.REFUSED;
        this.message = message;
    }

    /**
     * 标记服务的处理结果发生了异常.
     */
    public void markFailed() {
        this.code = FAILED_CODE;
        this.status = status_enum.FAILED;

    }

    /**
     * 标记服务的处理结果发生了异常.
     */
    public void markFailed(String message) {
        this.code = FAILED_CODE;
        this.status = status_enum.FAILED;
        this.message = message;
    }
}
