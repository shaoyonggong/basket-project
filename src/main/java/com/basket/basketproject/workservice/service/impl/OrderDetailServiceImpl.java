package com.basket.basketproject.workservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basket.basketproject.workservice.entity.OrderDetailPO;
import com.basket.basketproject.workservice.mapper.OrderDetailMapper;
import com.basket.basketproject.workservice.service.IOrderDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetailPO> implements IOrderDetailService {

}
