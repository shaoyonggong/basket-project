package com.basket.basketproject.workservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.basket.basketproject.utils.ConverterBy;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoEditDTO;
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
@ApiModel(value = "ProductBaseInfo对象", description = "")
public class ProductBaseInfoPO implements Serializable, ConverterBy<ProductBaseInfoEditDTO, ProductBaseInfoPO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品分类")
    private String classification;

    @ApiModelProperty(value = "图片链接")
    private String pictureUrl;

    @ApiModelProperty(value = "采购价格")
    private BigDecimal price;

    @ApiModelProperty(value = "销售价格")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "贴码")
    private String barCode;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "单位")
    private String measurement;

    @ApiModelProperty(value = "是否套装0否1是")
    private Integer isSuit;

    @ApiModelProperty(value = "其他信息")
    private String otherInfo;

    @ApiModelProperty(value = "是否启用0禁用1启用 ")
    private Integer state;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @Override
    public ProductBaseInfoPO convertBy(ProductBaseInfoEditDTO dto) {
        ProductBaseInfoPO po = new ProductBaseInfoPO();
        po.setProductCode(dto.getProductCode());
        po.setProductName(dto.getProductName());
        po.setClassification(dto.getClassification());
        po.setPictureUrl(dto.getPictureUrl());
        po.setPrice(dto.getPrice());
        po.setSalePrice(dto.getSalePrice());
        po.setBarCode(dto.getBarCode());
        po.setSpecifications(dto.getSpecifications());
        po.setMeasurement(dto.getMeasurement());
        po.setIsSuit(dto.getIsSuit());
        po.setOtherInfo(dto.getOtherInfo());
        po.setState(dto.getState());
        po.setUpdateBy(dto.getOperator());
        return po;
    }
}
