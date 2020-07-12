package com.basket.basketproject.workservice.entity;

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
@ApiModel(value="Promotion对象", description="")
public class PromotionPO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "促销表id")
    private Integer id;

    @ApiModelProperty(value = "促销编码")
    private String promotionCode;

    @ApiModelProperty(value = "促销名称")
    private String promotionName;

    @ApiModelProperty(value = "促销描述")
    private String promotionDescription;

    @ApiModelProperty(value = "促销产品编码")
    private String productCodes;

    @ApiModelProperty(value = "折扣")
    private BigDecimal discount;

    @ApiModelProperty(value = "状态 0禁用1启用")
    private Integer state;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
