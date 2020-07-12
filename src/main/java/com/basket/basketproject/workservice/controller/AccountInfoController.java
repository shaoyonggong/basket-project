package com.basket.basketproject.workservice.controller;

import com.basket.basketproject.constant.urlconstant.AccountUrlConstant;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoEditDTO;
import com.basket.basketproject.workservice.dto.accountinfo.AccountInfoSearchDTO;
import com.basket.basketproject.workservice.service.IAccountInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户管理前端控制器
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
@RestController
@RequestMapping
@Api(tags = {"分类：用户管理"})
public class AccountInfoController {

    @Autowired
    private IAccountInfoService accountInfoService;

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @PostMapping(AccountUrlConstant.ADD)
    public GlobalResult add(@Valid @RequestBody AccountInfoEditDTO dto) throws VerificationException {
        return accountInfoService.add(dto);
    }

    @ApiOperation(value = "启用禁用用户信息", notes = "启用禁用用户信息")
    @PostMapping(AccountUrlConstant.ENABLE)
    public GlobalResult enableDisable(@RequestParam Integer id, @RequestParam Integer state) {
        return accountInfoService.enableDisable(id, state);
    }

    @ApiOperation(value = "按照id查询用户", notes = "按照id查询用户")
    @PostMapping(AccountUrlConstant.SEARCH)
    public GlobalResult selectById(@RequestParam Integer id) {
        return accountInfoService.selectById(id);
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping(AccountUrlConstant.UPDATE)
    public GlobalResult update(@Valid @RequestBody AccountInfoEditDTO dto) throws VerificationException {
        return accountInfoService.edit(dto);
    }

    @ApiOperation(value = "条件查询用户", notes = "条件查询用户")
    @PostMapping(AccountUrlConstant.SEARCH_LIST)
    public GlobalResult selectByConditions(@Valid @RequestBody AccountInfoSearchDTO dto) {
        return accountInfoService.selectByConditions(dto);
    }
}

