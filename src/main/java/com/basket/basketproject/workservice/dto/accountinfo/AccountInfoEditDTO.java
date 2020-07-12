package com.basket.basketproject.workservice.dto.accountinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class AccountInfoEditDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户id", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "账户编码")
    private String accountCode;

    @ApiModelProperty(value = "账户姓名")
    @NotBlank(message = "姓名不能为空")
    private String accountName;

    @ApiModelProperty(value = "联系方式")
    @NotBlank(message = "联系方式不能为空")
    @Pattern(regexp = "^1[0-9]{10}$")
    private String phoneNo;

    @ApiModelProperty(value = "账户头像地址")
    private String headPortrait;

    @ApiModelProperty(value = "是否为员工 0否1是")
    @NotNull(message = "是否为员工不能为空")
    private Integer isEmployee;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "密码不能为空")
    private String accountPwd;

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
