package com.basket.basketproject.constant.urlconstant;

import com.basket.basketproject.constant.GlobalConstant;

/**
 * @Description 商品信息url常量
 * @Author shaoyonggong
 * @Date 2020/7/10
 */
public class ProductUrlConstant extends GlobalConstant {

    public ProductUrlConstant() {
    }

    public static final String PRODUCT = SERVICE_PATH + "/product/";

    public static final String ADD = PRODUCT + "add";
    public static final String ENABLE = PRODUCT + "enable";
    public static final String UPDATE = PRODUCT + "update";
    public static final String SEARCH = PRODUCT + "search";
    public static final String SEARCH_LIST = PRODUCT + "search/list";
}
