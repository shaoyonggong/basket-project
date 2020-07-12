package com.basket.basketproject.workservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="RoleControl对象", description="")
public class RoleControlPO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "账户")
    private String account;

    @ApiModelProperty(value = "账户角色")
    private String accountRole;

    @ApiModelProperty(value = "父级角色id")
    private Integer parentId;

    @ApiModelProperty(value = "描述")
    private String description;


}
