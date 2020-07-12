package com.basket.basketproject.workservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.basket.basketproject.utils.ConverterBy;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoEditDTO;
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
public class StationInfoPO implements Serializable, ConverterBy<StationInfoEditDTO, StationInfoPO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "驿站id")
    @TableId(value = "id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;

    @Override
    public StationInfoPO convertBy(StationInfoEditDTO dto) {
        StationInfoPO po = new StationInfoPO();
        po.setId(dto.getId());
        po.setStationCode(dto.getStationCode());
        po.setStationName(dto.getStationName());
        po.setStationLeader(dto.getStationLeader());
        po.setCommunity(dto.getCommunity());
        po.setBusinessHours(dto.getBusinessHours());
        po.setAddress(dto.getAddress());
        po.setDescs(dto.getDescs());
        po.setState(dto.getState());
        po.setUpdateBy(dto.getOperator());
        return po;
    }
}
