package com.basket.basketproject.workservice.dto.productinfo;

import com.basket.basketproject.utils.ConverterBy;
import com.basket.basketproject.utils.DateUtils;
import com.basket.basketproject.workservice.entity.ProductBaseInfoPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
public class ProductBaseInfoSearchRspDTO implements Serializable, ConverterBy<ProductBaseInfoPO, ProductBaseInfoSearchRspDTO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品表id")
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品分类")
    private String classification;

    @ApiModelProperty(value = "图片链接")
    private String pictureUrl;

    @ApiModelProperty(value = "图片链接集合")
    private List<String> pictureUrlList;

    public void setPictureUrlList() {
        this.pictureUrlList = Arrays.asList(this.pictureUrl.split(","));
    }

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

    @ApiModelProperty(value = "创建时间字符")
    private String createDateStr;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "更新时间字符")
    private String updateDateStr;

    @Override
    public ProductBaseInfoSearchRspDTO convertBy(ProductBaseInfoPO po) {
        ProductBaseInfoSearchRspDTO dto = new ProductBaseInfoSearchRspDTO();
        dto.setId(po.getId());
        dto.setProductCode(po.getProductCode());
        dto.setProductName(po.getProductName());
        dto.setClassification(po.getClassification());
        dto.setPictureUrl(po.getPictureUrl());
        dto.setPictureUrlList(Arrays.asList(this.pictureUrl.split(",")));
        dto.setPrice(po.getPrice());
        dto.setSalePrice(po.getSalePrice());
        dto.setBarCode(po.getBarCode());
        dto.setSpecifications(po.getSpecifications());
        dto.setMeasurement(po.getMeasurement());
        dto.setIsSuit(po.getIsSuit());
        dto.setOtherInfo(po.getOtherInfo());
        dto.setState(po.getState());
        dto.setCreateBy(po.getCreateBy());
        dto.setCreateDate(po.getCreateDate());
        dto.setUpdateBy(po.getUpdateBy());
        dto.setUpdateDate(po.getUpdateDate());
        dto.setCreateDateStr(DateUtils.localDateTimeToString(po.getCreateDate()));
        dto.setUpdateDateStr(DateUtils.localDateTimeToString(po.getUpdateDate()));
        return dto;
    }
}
