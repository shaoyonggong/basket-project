package com.basket.basketproject.utils;

import com.basket.basketproject.result.GlobalResult;

/**
 * @Description 公共的方法
 * @Author shaoyonggong
 * @Date 2020/7/11
 */
public class GlobalUtils {

    /**
     * 根据flag返回相应的结果
     *
     * @param flag
     * @return
     */
    public static GlobalResult resultProcess(boolean flag) {
        GlobalResult result = new GlobalResult();
        if (flag) {
            result.markSuccess("操作成功！");
        } else {
            result.markRefused("操作失败！");
        }
        return result;
    }
}
