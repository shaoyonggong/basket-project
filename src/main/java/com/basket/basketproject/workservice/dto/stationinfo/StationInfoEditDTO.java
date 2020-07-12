package com.basket.basketproject.workservice.dto.stationinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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
@ApiModel(value = "StationInfo对象", description = "")
public class StationInfoEditDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "驿站id", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "驿站编码")
    @NotBlank(message = "")
    private String stationCode;

    @ApiModelProperty(value = "驿站名称")
    @NotBlank(message = "")
    private String stationName;

    @ApiModelProperty(value = "驿站团长")
    @NotBlank(message = "")
    private String stationLeader;

    @ApiModelProperty(value = "社区")
    @NotBlank(message = "")
    private String community;

    @ApiModelProperty(value = "营业时间")
    @NotBlank(message = "")
    private String businessHours;

    @ApiModelProperty(value = "地址")
    @NotBlank(message = "")
    private String address;

    @ApiModelProperty(value = "备注")
    private String descs;

    @ApiModelProperty(value = "状态 0禁用1启用")
    private Integer state;

    @ApiModelProperty(value = "操作人")
    private String operator;

}
