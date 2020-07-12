package com.basket.basketproject.workservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basket.basketproject.workservice.entity.OrderPO;
import com.basket.basketproject.workservice.mapper.OrderMapper;
import com.basket.basketproject.workservice.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-11
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderPO> implements IOrderService {

}
