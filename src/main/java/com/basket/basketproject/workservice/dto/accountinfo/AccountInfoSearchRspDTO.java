package com.basket.basketproject.workservice.dto.accountinfo;

import com.basket.basketproject.utils.ConverterBy;
import com.basket.basketproject.workservice.entity.AccountInfoPO;
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
public class AccountInfoSearchRspDTO implements Serializable, ConverterBy<AccountInfoPO, AccountInfoSearchRspDTO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户id")
    private Integer id;

    @ApiModelProperty(value = "账户编码")
    private String accountCode;

    @ApiModelProperty(value = "账户姓名")
    private String accountName;

    @ApiModelProperty(value = "联系方式")
    private String phoneNo;

    @ApiModelProperty(value = "账户头像地址")
    private String headPortrait;

    @ApiModelProperty(value = "是否为员工 0否1是")
    private Integer isEmployee;

    @ApiModelProperty(value = "密码")
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

    @Override
    public AccountInfoSearchRspDTO convertBy(AccountInfoPO po) {
        AccountInfoSearchRspDTO dto = new AccountInfoSearchRspDTO();
        dto.setId(po.getId());
        dto.setAccountCode(po.getAccountCode());
        dto.setAccountName(po.getAccountName());
        dto.setPhoneNo(po.getPhoneNo().toString());
        dto.setHeadPortrait(po.getHeadPortrait());
        dto.setIsEmployee(po.getIsEmployee());
        dto.setAccountPwd(po.getAccountPwd());
        dto.setBalance(po.getBalance());
        dto.setAccountLevel(po.getAccountLevel());
        dto.setIntegral(po.getIntegral());
        dto.setGiftCard(po.getGiftCard());
        dto.setCoupon(po.getCoupon());
        dto.setAddress(po.getAddress());
        dto.setOtherInfo(po.getOtherInfo());
        return dto;
    }
}
