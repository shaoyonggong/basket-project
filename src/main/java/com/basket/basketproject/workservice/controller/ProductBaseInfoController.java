package com.basket.basketproject.workservice.controller;

import com.basket.basketproject.constant.urlconstant.ProductUrlConstant;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoEditDTO;
import com.basket.basketproject.workservice.dto.productinfo.ProductBaseInfoSearchDTO;
import com.basket.basketproject.workservice.service.IProductBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
@RestController
@RequestMapping
@Api(tags = {"分类：商品管理"})
public class ProductBaseInfoController {

    @Autowired
    private IProductBaseInfoService productBaseInfoService;

    @ApiOperation(value = "新增商品信息", notes = "新增商品信息")
    @PostMapping(ProductUrlConstant.ADD)
    public GlobalResult add(@Valid @RequestBody ProductBaseInfoEditDTO dto) throws VerificationException {
        return productBaseInfoService.add(dto);
    }

    @ApiOperation(value = "启用禁用商品信息", notes = "启用禁用商品信息")
    @PostMapping(ProductUrlConstant.ENABLE)
    public GlobalResult enableDisable(@RequestParam Integer id, @RequestParam Integer state) {
        return productBaseInfoService.enableDisable(id, state);
    }

    @ApiOperation(value = "按照id查询商品", notes = "按照id查询商品")
    @PostMapping(ProductUrlConstant.SEARCH)
    public GlobalResult selectById(@RequestParam Integer id) {
        return productBaseInfoService.selectById(id);
    }

    @ApiOperation(value = "更新商品信息", notes = "更新商品信息")
    @PostMapping(ProductUrlConstant.UPDATE)
    public GlobalResult update(@Valid @RequestBody ProductBaseInfoEditDTO dto) throws VerificationException {
        return productBaseInfoService.edit(dto);
    }

    @ApiOperation(value = "条件查询商品", notes = "条件查询商品")
    @PostMapping(ProductUrlConstant.SEARCH_LIST)
    public GlobalResult selectByConditions(@Valid @RequestBody ProductBaseInfoSearchDTO dto) {
        return productBaseInfoService.selectByConditions(dto);
    }
}

