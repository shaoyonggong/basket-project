package com.basket.basketproject.workservice.dto.productinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
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
@ApiModel(value = "ProductBaseInfo对象", description = "")
public class ProductBaseInfoEditDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品表id",hidden = true)
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    @NotBlank(message = "商品编码不能为空")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    @NotBlank(message = "商品名称不能为空")
    private String productName;

    @ApiModelProperty(value = "商品分类")
    private String classification;

    @ApiModelProperty(value = "图片链接")
    private String pictureUrl;

    @ApiModelProperty(value = "采购价格")
    @DecimalMin(value = "0")
    private BigDecimal price;

    @ApiModelProperty(value = "销售价格")
    @DecimalMin(value = "0")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "贴码")
    private String barCode;

    @ApiModelProperty(value = "规格")
    @NotBlank(message = "规格不能为空")
    private String specifications;

    @ApiModelProperty(value = "单位")
    private String measurement;

    @ApiModelProperty(value = "是否套装0否1是")
    private Integer isSuit;

    @ApiModelProperty(value = "其他信息")
    private String otherInfo;

    @ApiModelProperty(value = "是否启用0禁用1启用 ")
    private Integer state;

    @ApiModelProperty(value = "操作人")
    @NotBlank(message = "操作人不能为空")
    private String operator;

}
