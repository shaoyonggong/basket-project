package com.basket.basketproject.workservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basket.basketproject.constant.ordinaryconstant.ProductConstant;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.utils.GlobalUtils;
import com.basket.basketproject.utils.TransactionUtil;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoEditDTO;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoSearchDTO;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoSearchRspDTO;
import com.basket.basketproject.workservice.entity.ProductBaseInfoPO;
import com.basket.basketproject.workservice.mapper.ProductBaseInfoMapper;
import com.basket.basketproject.workservice.service.IProductBaseInfoService;
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
public class ProductBaseInfoServiceImpl extends ServiceImpl<ProductBaseInfoMapper, ProductBaseInfoPO> implements IProductBaseInfoService {

    @Autowired
    TransactionUtil tran;

    @Override
    public GlobalResult add(ProductBaseInfoEditDTO dto) throws VerificationException {
        //检查商品编码是否重复
        LambdaQueryWrapper<ProductBaseInfoPO> lambda = new QueryWrapper<ProductBaseInfoPO>().lambda();
        lambda.eq(ProductBaseInfoPO::getProductCode, dto.getProductCode());

        List<ProductBaseInfoPO> judgementList = baseMapper.selectList(lambda);
        if (judgementList != null || judgementList.size() > 0) {
            throw new VerificationException("商品编码已存在，请重新命名");
        }
        ProductBaseInfoPO insertPO = new ProductBaseInfoPO();
        BeanUtils.copyProperties(dto, insertPO);
        insertPO.setCreateBy(dto.getOperator());
        insertPO.setUpdateBy(dto.getOperator());
        insertPO.setIsSuit(ProductConstant.PRODUCT_PART);
        insertPO.setState(ProductConstant.PRODUCT_STATE_ENABLE);

        boolean tranFlag = tran.transact(s -> {
            baseMapper.insert(insertPO);
            log.info("新增商品信息成功！商品信息：[{}]", JSONObject.toJSONString(insertPO));
            return true;
        });
        return GlobalUtils.resultProcess(tranFlag);
    }

    @Override
    public GlobalResult enableDisable(Integer id, Integer state) {

        LambdaQueryWrapper<ProductBaseInfoPO> lambda = new QueryWrapper<ProductBaseInfoPO>().lambda();
        lambda.eq(ProductBaseInfoPO::getId, id);

        ProductBaseInfoPO po = new ProductBaseInfoPO();
        po.setId(id);
        po.setState(state);

        return GlobalUtils.resultProcess((baseMapper.update(po, lambda) > 0) ? true : false);
    }

    @Override
    public GlobalResult selectById(Integer id) {

        GlobalResult result = new GlobalResult();

        ProductBaseInfoPO infoPO = baseMapper.selectById(id);
        ProductBaseInfoSearchRspDTO infoDTO = new ProductBaseInfoSearchRspDTO().convertBy(infoPO);

        result.setBody(infoDTO);
        return result;
    }

    @Override
    public GlobalResult edit(ProductBaseInfoEditDTO dto) throws VerificationException {

        //确保新修改的商品编码除该条外无重复
        LambdaQueryWrapper<ProductBaseInfoPO> queryWrapper = new QueryWrapper<ProductBaseInfoPO>().lambda();
        queryWrapper.ne(ProductBaseInfoPO::getId, dto.getId())
                .eq(ProductBaseInfoPO::getProductCode, dto.getProductCode());
        ProductBaseInfoPO infoPO = baseMapper.selectOne(queryWrapper);

        if (infoPO != null) {
            throw new VerificationException("该商品编码" + dto.getProductCode() + "已存在！请修改键入信息或修改原商品信息！");
        }
        //更新
        ProductBaseInfoPO updatePo = new ProductBaseInfoPO().convertBy(dto);

        return GlobalUtils.resultProcess((baseMapper.updateById(updatePo) > 0) ? true : false);
    }

    @Override
    public GlobalResult selectByConditions(ProductBaseInfoSearchDTO dto) {

        GlobalResult result = new GlobalResult();

        LambdaQueryWrapper<ProductBaseInfoPO> queryWrapper = new QueryWrapper<ProductBaseInfoPO>().lambda();

        if (StringUtil.isNotBlank(dto.getProductCode())) {
            queryWrapper.in(ProductBaseInfoPO::getProductCode, dto.getProductCode().split(","));
        }
        queryWrapper
                .like(StringUtil.isNotBlank(dto.getProductName()), ProductBaseInfoPO::getProductName, dto.getProductName())
                .eq(StringUtil.isNotBlank(dto.getClassification()), ProductBaseInfoPO::getClassification, dto.getClassification())
                .eq(null != dto.getIsSuit(), ProductBaseInfoPO::getIsSuit, dto.getIsSuit())
                .like(StringUtil.isNotBlank(dto.getOtherInfo()), ProductBaseInfoPO::getOtherInfo, dto.getOtherInfo());

        Page<ProductBaseInfoPO> page = new Page<ProductBaseInfoPO>(dto.getPageNum(), dto.getPageSize());
        List<ProductBaseInfoSearchRspDTO> rspDTOList = baseMapper.selectPage(page, queryWrapper).getRecords().stream().map(p -> {
            return new ProductBaseInfoSearchRspDTO().convertBy(p);
        }).collect(Collectors.toList());

        result.setBody(rspDTOList);
        result.setTotalCount(rspDTOList.size());

        return result;
    }
}
