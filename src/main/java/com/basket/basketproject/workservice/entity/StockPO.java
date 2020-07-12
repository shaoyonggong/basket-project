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
@ApiModel(value="Stock对象", description="")
public class StockPO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "库存表id")
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    private String productCode;

    @ApiModelProperty(value = "可用库存数")
    private Integer availableNum;

    @ApiModelProperty(value = "库存占用数")
    private Integer occupyNum;

    @ApiModelProperty(value = "失效库存数")
    private Integer invalidNum;

    @ApiModelProperty(value = "仓库编码")
    private String warehouseCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
