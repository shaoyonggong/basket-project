package com.basket.basketproject.workservice.dto.accountinfo;

import com.basket.basketproject.workservice.dto.PageParamDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AccountInfo对象", description = "")
public class AccountInfoSearchDTO extends PageParamDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户编码")
    private String accountCode;

    @ApiModelProperty(value = "账户姓名")
    private String accountName;

    @ApiModelProperty(value = "联系方式")
    private String phoneNo;

    @ApiModelProperty(value = "是否为员工 0否1是")
    private Integer isEmployee;

    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "账户等级 0普通会员1银卡会员2金卡会员4钻石卡会员8超级会员")
    private Integer accountLevel;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @ApiModelProperty(value = "礼品卡编码")
    private String giftCard;

    @ApiModelProperty(value = "优惠券编码")
    private String coupon;

    @ApiModelProperty(value = "收货地址")
    private String address;

    @ApiModelProperty(value = "其他信息")
    private String otherInfo;

}
