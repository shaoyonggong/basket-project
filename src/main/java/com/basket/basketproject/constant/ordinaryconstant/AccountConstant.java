package com.basket.basketproject.constant.ordinaryconstant;

/**
 * @Description 账户信息普通常量
 * @Author shaoyonggong
 * @Date 2020/7/10
 */
public class AccountConstant {

    /**
     * 账户等级 0普通会员1银卡会员2金卡会员4钻石会员8超级会员
     */
    public static final Integer ACCOUNT_LEVEL_GENERAL = 0;
    public static final Integer ACCOUNT_LEVEL_SILVER = 1;
    public static final Integer ACCOUNT_LEVEL_GOLD = 2;
    public static final Integer ACCOUNT_LEVEL_DIAMOND = 4;
    public static final Integer ACCOUNT_LEVEL_SUPER = 8;

    public static final String ACCOUNT_LEVEL_GENERAL_STR = "普通会员";
    public static final String ACCOUNT_LEVEL_SILVER_STR = "银卡会员";
    public static final String ACCOUNT_LEVEL_GOLD_STR = "金卡会员";
    public static final String ACCOUNT_LEVEL_DIAMOND_STR = "钻石会员";
    public static final String ACCOUNT_LEVEL_SUPER_STR = "超级会员";

    /**
     * 账户状态 0正常1已注销(客户)或离职(员工)
     */
    public static final Integer ACCOUNT_STATE_NORMAL = 0;
    public static final Integer ACCOUNT_STATE_CANCELLATION = 1;
}
