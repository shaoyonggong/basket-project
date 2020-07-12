package com.basket.basketproject.workservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.utils.GlobalUtils;
import com.basket.basketproject.utils.TransactionUtil;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoEditDTO;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoSearchDTO;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoSearchRspDTO;
import com.basket.basketproject.workservice.entity.StationInfoPO;
import com.basket.basketproject.workservice.mapper.StationInfoMapper;
import com.basket.basketproject.workservice.service.IStationInfoService;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class StationInfoServiceImpl extends ServiceImpl<StationInfoMapper, StationInfoPO> implements IStationInfoService {

    @Autowired
    TransactionUtil tran;

    @Override
    public GlobalResult add(StationInfoEditDTO dto) throws VerificationException {

        //检查驿站信息是否存在
        checkStationExists(dto.getStationCode());

        StationInfoPO insertPO = new StationInfoPO();
        BeanUtils.copyProperties(dto, insertPO);
        insertPO.setCreateBy(dto.getOperator());
        insertPO.setUpdateBy(dto.getOperator());
        boolean tranFlag = tran.transact(s -> {
            baseMapper.insert(insertPO);
            log.info("新增商品信息成功！商品信息：[{}]", JSONObject.toJSONString(insertPO));
            return true;
        });
        return GlobalUtils.resultProcess(tranFlag);
    }

    @Override
    public GlobalResult enableDisable(Integer id, Integer state) {

        LambdaQueryWrapper<StationInfoPO> lambda = new QueryWrapper<StationInfoPO>().lambda();
        lambda.eq(StationInfoPO::getId, id);

        StationInfoPO po = new StationInfoPO();
        po.setId(id);
        po.setState(state);

        return GlobalUtils.resultProcess((baseMapper.update(po, lambda) > 0) ? true : false);
    }

    @Override
    public GlobalResult selectById(Integer id) {

        GlobalResult result = new GlobalResult();

        StationInfoPO infoPO = baseMapper.selectById(id);
        StationInfoSearchRspDTO infoDTO = new StationInfoSearchRspDTO().convertBy(infoPO);

        result.setBody(infoDTO);
        return result;
    }

    @Override
    public GlobalResult edit(StationInfoEditDTO dto) throws VerificationException {

        //检查驿站信息是否存在
        checkStationExists(dto.getStationCode());

        //更新
        StationInfoPO updatePo = new StationInfoPO().convertBy(dto);

        return GlobalUtils.resultProcess((baseMapper.updateById(updatePo) > 0) ? true : false);
    }

    /**
     * 判断驿站是否存在
     *
     * @param stationCode
     * @throws VerificationException
     */
    private void checkStationExists(String stationCode) throws VerificationException {

        LambdaQueryWrapper<StationInfoPO> lambda = new QueryWrapper<StationInfoPO>().lambda();
        lambda.eq(StationInfoPO::getStationCode, stationCode);

        List<StationInfoPO> judgementList = baseMapper.selectList(lambda);
        if (judgementList != null || judgementList.size() > 0) {
            throw new VerificationException("驿站编码已存在，请重新命名");
        }
    }

    @Override
    public GlobalResult selectByConditions(StationInfoSearchDTO dto) {
        GlobalResult result = new GlobalResult();

        LambdaQueryWrapper<StationInfoPO> queryWrapper = new QueryWrapper<StationInfoPO>().lambda();


        queryWrapper
                .eq(StringUtil.isNotBlank(dto.getStationCode()), StationInfoPO::getStationCode, dto.getStationCode())
                .like(StringUtil.isNotBlank(dto.getStationName()), StationInfoPO::getStationName, dto.getStationName())
                .eq(StringUtil.isNotBlank(dto.getStationLeader()), StationInfoPO::getStationLeader, dto.getStationLeader())
                .like(StringUtil.isNotBlank(dto.getCommunity()), StationInfoPO::getCommunity, dto.getCommunity())
                .like(StringUtil.isNotBlank(dto.getBusinessHours()), StationInfoPO::getBusinessHours, dto.getBusinessHours())
                .like(StringUtil.isNotBlank(dto.getAddress()), StationInfoPO::getAddress, dto.getAddress())
                .like(StringUtil.isNotBlank(dto.getDescs()), StationInfoPO::getDescs, dto.getDescs());

        Page<StationInfoPO> page = new Page<StationInfoPO>(dto.getPageNum(), dto.getPageSize());
        List<StationInfoSearchRspDTO> rspDTOList = baseMapper.selectPage(page, queryWrapper).getRecords().stream().map(p -> {
            return new StationInfoSearchRspDTO().convertBy(p);
        }).collect(Collectors.toList());

        result.setBody(rspDTOList);
        result.setTotalCount(rspDTOList.size());

        return result;
    }
}
