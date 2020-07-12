package com.basket.basketproject.workservice.dto.stationinfo;

import com.basket.basketproject.utils.ConverterBy;
import com.basket.basketproject.utils.DateUtils;
import com.basket.basketproject.workservice.entity.StationInfoPO;
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
@ApiModel(value = "StationInfo对象", description = "")
public class StationInfoSearchRspDTO implements Serializable, ConverterBy<StationInfoPO, StationInfoSearchRspDTO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "驿站id", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "驿站编码")
    private String stationCode;

    @ApiModelProperty(value = "驿站名称")
    private String stationName;

    @ApiModelProperty(value = "驿站团长")
    private String stationLeader;

    @ApiModelProperty(value = "社区")
    private String community;

    @ApiModelProperty(value = "营业时间")
    private String businessHours;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "备注")
    private String descs;

    @ApiModelProperty(value = "状态 0禁用1启用")
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
    public StationInfoSearchRspDTO convertBy(StationInfoPO po) {
        StationInfoSearchRspDTO dto = new StationInfoSearchRspDTO();
        dto.setId(po.getId());
        dto.setStationCode(po.getStationCode());
        dto.setStationName(po.getStationName());
        dto.setStationLeader(po.getStationLeader());
        dto.setCommunity(po.getCommunity());
        dto.setBusinessHours(po.getBusinessHours());
        dto.setAddress(po.getAddress());
        dto.setDescs(po.getDescs());
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
