package com.basket.basketproject.workservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.basket.basketproject.constant.ordinaryconstant.AccountConstant;
import com.basket.basketproject.utils.ConverterBy;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoEditDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@TableName("account_info")
public class AccountInfoPO implements Serializable, ConverterBy<AccountInfoEditDTO, AccountInfoPO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账户编码")
    private String accountCode;

    @ApiModelProperty(value = "账户姓名")
    private String accountName;

    @ApiModelProperty(value = "联系方式")
    private Long phoneNo;

    @ApiModelProperty(value = "账户头像地址")
    private String headPortrait;

    @ApiModelProperty(value = "是否为员工 0否1是")
    private Integer isEmployee;

    @ApiModelProperty(value = "状态 0正常1已注销(客户)或离职(员工)")
    private Integer state;

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

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @Override
    public AccountInfoPO convertBy(AccountInfoEditDTO dto) {
        AccountInfoPO po = new AccountInfoPO();
        po.setId(dto.getId());
        po.setAccountCode(dto.getPhoneNo());
        po.setAccountName(dto.getAccountName());
        po.setPhoneNo(Long.parseLong(dto.getPhoneNo()));
        po.setHeadPortrait(dto.getHeadPortrait());
        po.setIsEmployee(dto.getIsEmployee());
        po.setState(AccountConstant.ACCOUNT_STATE_NORMAL);
        po.setAccountPwd(dto.getAccountPwd());
        po.setBalance(BigDecimal.ZERO);
        po.setGiftCard(dto.getGiftCard());
        po.setCoupon(dto.getCoupon());
        po.setAddress(dto.getAddress());
        po.setOtherInfo(dto.getOtherInfo());
        //根据前后台不同校验不同信息和赋值
        switch (dto.getIsEmployee()) {
            case 0:
                po.setAccountLevel(AccountConstant.ACCOUNT_LEVEL_GENERAL);
                po.setIntegral(0);
                break;
            default:
                po.setAccountLevel(AccountConstant.ACCOUNT_LEVEL_SILVER);
                po.setIntegral(1000);
        }
        return po;
    }
}
