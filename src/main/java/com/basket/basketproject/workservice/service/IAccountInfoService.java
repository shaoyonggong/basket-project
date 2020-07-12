package com.basket.basketproject.workservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoEditDTO;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoSearchDTO;
import com.basket.basketproject.workservice.entity.AccountInfoPO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
public interface IAccountInfoService extends IService<AccountInfoPO> {

    /**
     * 新增人员信息
     *
     * @param dto
     * @return
     * @throws VerificationException
     */
    GlobalResult add(AccountInfoEditDTO dto) throws VerificationException;

    /**
     * 按照注册号码删除
     *
     *
     * @param id
     * @param state
     * @return
     */
    GlobalResult enableDisable(Integer id, Integer state);

    /**
     * 按照注册号码查询
     *
     * @param phoneNo
     * @return
     */
    GlobalResult selectById(Integer phoneNo);

    /**
     * 更新用户信息
     *
     * @param dto
     * @return
     * @throws VerificationException
     */
    GlobalResult edit(AccountInfoEditDTO dto) throws VerificationException;

    /**
     * 条件查询账户信息
     *
     * @param dto
     * @return
     */
    GlobalResult selectByConditions(AccountInfoSearchDTO dto);

}
