package com.basket.basketproject.workservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoEditDTO;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoSearchDTO;
import com.basket.basketproject.workservice.entity.StationInfoPO;

/**
 * <p>
 * 驿站信息服务类
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
public interface IStationInfoService extends IService<StationInfoPO> {

    /**
     * 新增驿站信息
     *
     * @param dto
     * @return
     * @throws VerificationException
     */
    GlobalResult add(StationInfoEditDTO dto) throws VerificationException;

    /**
     * 按照注册号码删除
     *
     * @param id
     * @param state
     * @return
     */
    GlobalResult enableDisable(Integer id, Integer state);

    /**
     * 按照注册号码查询
     *
     * @param id
     * @return
     */
    GlobalResult selectById(Integer id);

    /**
     * 更新驿站信息
     *
     * @param dto
     * @return
     * @throws VerificationException
     */
    GlobalResult edit(StationInfoEditDTO dto) throws VerificationException;

    /**
     * 条件查询驿站信息
     *
     * @param dto
     * @return
     */
    GlobalResult selectByConditions(StationInfoSearchDTO dto);
}
