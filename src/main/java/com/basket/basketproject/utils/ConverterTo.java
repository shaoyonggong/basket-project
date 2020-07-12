package com.basket.basketproject.utils;

/**
 * @Description 公共的方法
 * @Author shaoyonggong
 * @Date 2020/7/11
 */
public interface ConverterTo<R> {
  /**
   * 转换成
   * @return
   */
  public R convertTo() throws Exception;
}
