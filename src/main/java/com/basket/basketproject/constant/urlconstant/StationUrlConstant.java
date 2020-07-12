package com.basket.basketproject.constant.urlconstant;

import com.basket.basketproject.constant.GlobalConstant;

/**
 * @Description 账户信息url常量
 * @Author shaoyonggong
 * @Date 2020/7/10
 */
public class StationUrlConstant extends GlobalConstant {

    public StationUrlConstant() {
    }

    public static final String STATION = SERVICE_PATH + "/station/";

    public static final String ADD = STATION + "add";
    public static final String ENABLE = STATION + "enable";
    public static final String UPDATE = STATION + "update";
    public static final String SEARCH = STATION + "search";
    public static final String SEARCH_LIST = STATION + "search/list";
}
