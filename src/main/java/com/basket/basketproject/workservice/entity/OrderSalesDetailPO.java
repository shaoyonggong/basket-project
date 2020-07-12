package com.basket.basketproject.workservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="OrderSalesDetail对象", description="")
public class OrderSalesDetailPO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "明细表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单编号")
    private String orderCode;

    @ApiModelProperty(value = "行号")
    private Integer lineNo;

    @ApiModelProperty(value = "产品编码")
    private String productCode;

    @ApiModelProperty(value = "下单数量")
    private Integer totalNum;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal price;

    @ApiModelProperty(value = "备注")
    private String descs;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
