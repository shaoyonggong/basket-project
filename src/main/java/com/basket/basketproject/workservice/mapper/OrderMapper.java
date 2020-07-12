package com.basket.basketproject.workservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basket.basketproject.workservice.entity.OrderPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-11
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {

}
