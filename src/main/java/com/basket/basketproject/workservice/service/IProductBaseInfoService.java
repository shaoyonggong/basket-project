package com.basket.basketproject.workservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoEditDTO;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoSearchDTO;
import com.basket.basketproject.workservice.entity.ProductBaseInfoPO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
public interface IProductBaseInfoService extends IService<ProductBaseInfoPO> {

    /**
     * 新增商品信息
     *
     * @param dto
     * @return
     */
    GlobalResult add(ProductBaseInfoEditDTO dto) throws VerificationException;

    /**
     * 启用禁用商品信息
     *
     * @param id
     * @param state
     * @return
     */
    GlobalResult enableDisable(Integer id, Integer state);

    /**
     * 按主键查询
     *
     * @param id
     * @return
     */
    GlobalResult selectById(Integer id);

    /**
     * 修改商品信息
     *
     * @param dto
     * @return
     */
    GlobalResult edit(ProductBaseInfoEditDTO dto) throws VerificationException;

    /**
     * 条件查询商品信息
     *
     * @param dto
     * @return
     */
    GlobalResult selectByConditions(ProductBaseInfoSearchDTO dto);
}
