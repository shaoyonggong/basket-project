package com.basket.basketproject.workservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basket.basketproject.constant.ordinaryconstant.AccountConstant;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.utils.GlobalUtils;
import com.basket.basketproject.utils.TransactionUtil;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoEditDTO;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoSearchDTO;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoSearchRspDTO;
import com.basket.basketproject.workservice.entity.AccountInfoPO;
import com.basket.basketproject.workservice.mapper.AccountInfoMapper;
import com.basket.basketproject.workservice.service.IAccountInfoService;
import com.google.gson.Gson;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
@Service
@Slf4j
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfoPO> implements IAccountInfoService {

    @Autowired
    TransactionUtil tran;

    @Override
    public GlobalResult add(AccountInfoEditDTO dto) throws VerificationException {

        //校验手机号是否已经注册
        GlobalResult result = checkRegistered(Long.parseLong(dto.getPhoneNo()));

        if (!result.getCode().equals(GlobalResult.SUCCESS_CODE)) {
            return result;
        }

        AccountInfoPO po = new AccountInfoPO().convertBy(dto);

        boolean tranRes = tran.transact(s -> {
            baseMapper.insert(po);
            log.info("新用户注册成功！用户信息[{}]", new Gson().toJson(po));
            return true;
        });

        if (!tranRes) {
            result.markRefused("注册失败！请重试！");
        }

        return result;
    }

    /**
     * 校验手机号是否已经注册
     *
     * @param phoneNo
     * @return
     */
    private GlobalResult checkRegistered(Long phoneNo) {

        GlobalResult result = new GlobalResult();

        LambdaQueryWrapper<AccountInfoPO> queryWrapper = new QueryWrapper<AccountInfoPO>().lambda();
        queryWrapper.eq(AccountInfoPO::getPhoneNo, phoneNo)
                .ne(AccountInfoPO::getState, AccountConstant.ACCOUNT_STATE_CANCELLATION);
        AccountInfoPO accountInfoPO = baseMapper.selectOne(queryWrapper);

        if (accountInfoPO != null) {
            result.markRefused("该手机号码已被注册！");
        }
        return result;
    }

    @Override
    public GlobalResult enableDisable(Integer id, Integer state) {

        LambdaQueryWrapper<AccountInfoPO> lambda = new QueryWrapper<AccountInfoPO>().lambda();
        lambda.eq(AccountInfoPO::getId, id);

        AccountInfoPO accountInfoPO = new AccountInfoPO();
        accountInfoPO.setId(id);
        accountInfoPO.setState(state);

        return GlobalUtils.resultProcess((baseMapper.update(accountInfoPO, lambda) > 0) ? true : false);
    }

    /**
     * 校验手机号是否符合规则
     *
     * @param phoneNo
     */
    private void checkPhoneNoConformRules(String phoneNo) throws VerificationException {
        String regexp = "^1[0-9]{10}$";
        if (!Pattern.matches(regexp, phoneNo)) {
            throw new VerificationException("手机号码格式不正确！");
        }
    }

    @Override
    public GlobalResult selectById(Integer id) {

        GlobalResult result = new GlobalResult();

        AccountInfoPO infoPO = baseMapper.selectById(id);
        AccountInfoSearchRspDTO infoDTO = new AccountInfoSearchRspDTO().convertBy(infoPO);

        result.setBody(infoDTO);
        return result;
    }

    @Override
    public GlobalResult edit(AccountInfoEditDTO dto) throws VerificationException {

        //确保新修改的电话号码除该条外无重复有效的
        LambdaQueryWrapper<AccountInfoPO> queryWrapper = new QueryWrapper<AccountInfoPO>().lambda();
        queryWrapper.ne(AccountInfoPO::getId, dto.getId())
                .eq(AccountInfoPO::getPhoneNo, dto.getPhoneNo())
                .ne(AccountInfoPO::getState, AccountConstant.ACCOUNT_STATE_CANCELLATION);
        AccountInfoPO infoPO = baseMapper.selectOne(queryWrapper);

        if (infoPO != null) {
            throw new VerificationException("该电话号码" + dto.getPhoneNo() + "已被其他用户占用！");
        }
        //更新
        AccountInfoPO updatePo = new AccountInfoPO().convertBy(dto);

        return GlobalUtils.resultProcess((baseMapper.updateById(updatePo) > 0) ? true : false);
    }

    @Override
    public GlobalResult selectByConditions(AccountInfoSearchDTO dto) {

        GlobalResult result = new GlobalResult();

        LambdaQueryWrapper<AccountInfoPO> queryWrapper = new QueryWrapper<AccountInfoPO>().lambda();

        if (StringUtil.isNotBlank(dto.getAccountCode())) {
            queryWrapper.in(AccountInfoPO::getAccountCode, dto.getAccountCode().split(","));
        }
        if (StringUtil.isNotBlank(dto.getPhoneNo())) {
            queryWrapper.in(AccountInfoPO::getPhoneNo, dto.getPhoneNo().split(","));
        }
        queryWrapper
                .like(StringUtil.isNotBlank(dto.getAccountName()), AccountInfoPO::getAccountName, dto.getAccountName())
                .eq(null != dto.getIsEmployee(), AccountInfoPO::getIsEmployee, dto.getIsEmployee())
                .ge(null != dto.getBalance(), AccountInfoPO::getBalance, dto.getBalance())
                .eq(null != dto.getAccountLevel(), AccountInfoPO::getAccountLevel, dto.getAccountLevel())
                .ge(null != dto.getIntegral(), AccountInfoPO::getIntegral, dto.getIntegral())
                .like(StringUtil.isNotBlank(dto.getGiftCard()), AccountInfoPO::getGiftCard, dto.getGiftCard())
                .like(StringUtil.isNotBlank(dto.getCoupon()), AccountInfoPO::getCoupon, dto.getCoupon())
                .like(StringUtil.isNotBlank(dto.getAddress()), AccountInfoPO::getAddress, dto.getAddress())
                .like(StringUtil.isNotBlank(dto.getOtherInfo()), AccountInfoPO::getOtherInfo, dto.getOtherInfo());

        Page<AccountInfoPO> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        List<AccountInfoSearchRspDTO> rspDTOList = baseMapper.selectPage(page, queryWrapper).getRecords().stream().map(p -> {
            return new AccountInfoSearchRspDTO().convertBy(p);
        }).collect(Collectors.toList());

        result.setBody(rspDTOList);
        result.setTotalCount(rspDTOList.size());

        return result;
    }
}
