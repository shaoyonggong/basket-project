package com.basket.basketproject.workservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
@ApiModel(value="StockDetail对象", description="")
public class StockDetailPO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "库存明细表id")
    private Integer id;

    @ApiModelProperty(value = "库存表id")
    private Integer stockId;

    @ApiModelProperty(value = "商品编码")
    private String productCode;

    @ApiModelProperty(value = "商品等级 G好品B坏品GB好坏品")
    private String productGrade;

    @ApiModelProperty(value = "仓库编码")
    private String warehouseCode;

    @ApiModelProperty(value = "数量")
    private Integer num;

    @ApiModelProperty(value = "批次")
    private String batchNo;

    @ApiModelProperty(value = "入库日期")
    private LocalDateTime stockInDate;

    @ApiModelProperty(value = "失效日期")
    private LocalDateTime invalidDate;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
