package com.basket.basketproject.workservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basket.basketproject.workservice.entity.StockPO;
import com.basket.basketproject.workservice.mapper.StockMapper;
import com.basket.basketproject.workservice.service.IStockService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, StockPO> implements IStockService {

}
