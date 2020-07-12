package com.basket.basketproject.constant.urlconstant;

import com.basket.basketproject.constant.GlobalConstant;

/**
 * @Description 账户信息url常量
 * @Author shaoyonggong
 * @Date 2020/7/10
 */
public class AccountUrlConstant extends GlobalConstant {

    public AccountUrlConstant() {
    }

    public static final String ACCOUNT = SERVICE_PATH + "/account/";

    public static final String ADD = ACCOUNT + "add";
    public static final String ENABLE = ACCOUNT + "enable";
    public static final String UPDATE = ACCOUNT + "update";
    public static final String SEARCH = ACCOUNT + "search";
    public static final String SEARCH_LIST = ACCOUNT + "search/list";
}
