package com.basket.basketproject.workservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author shaoyonggong
 * @Date 2020/7/12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PageParamDto对象", description = "")
public class PageParamDTO {

    @NotNull(message = "页码不能为空")
    @ApiModelProperty(value = "页码", example = "1", required = true)
    private Integer pageNum;

    @NotNull(message = "分页大小不能为空")
    @ApiModelProperty(value = "分页大小", example = "10", required = true)
    private Integer pageSize;
}
