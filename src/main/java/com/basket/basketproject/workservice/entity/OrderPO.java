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
@ApiModel(value="Order对象", description="")
public class OrderPO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单编号")
    private String orderCode;

    @ApiModelProperty(value = "消费者")
    private String consumer;

    @ApiModelProperty(value = "驿站编码")
    private String stationCode;

    @ApiModelProperty(value = "产品种类数")
    private Integer productNum;

    @ApiModelProperty(value = "总数量")
    private Integer totalNum;

    @ApiModelProperty(value = "总价格")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "提货人")
    private String deliveryTo;

    @ApiModelProperty(value = "提货人联系方式")
    private Integer deliveryPhone;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
