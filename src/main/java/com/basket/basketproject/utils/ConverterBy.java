package com.basket.basketproject.utils;

/**
 * @Description 公共的方法
 * @Author shaoyonggong
 * @Date 2020/7/11
 */
public interface ConverterBy<T,R> {
  /**
   * 转换自
   * @return
   */
  public R convertBy(T t);
}
