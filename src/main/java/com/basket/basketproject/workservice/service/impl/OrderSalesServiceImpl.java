package com.basket.basketproject.workservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basket.basketproject.workservice.entity.OrderSalesPO;
import com.basket.basketproject.workservice.mapper.OrderSalesMapper;
import com.basket.basketproject.workservice.service.IOrderSalesService;
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
public class OrderSalesServiceImpl extends ServiceImpl<OrderSalesMapper, OrderSalesPO> implements IOrderSalesService {

}
