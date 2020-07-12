package com.basket.basketproject.workservice.controller;

import com.basket.basketproject.constant.urlconstant.StationUrlConstant;
import com.basket.basketproject.exception.VerificationException;
import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoEditDTO;
import com.basket.basketproject.workservice.dto.stationinfo.StationInfoSearchDTO;
import com.basket.basketproject.workservice.service.IStationInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaoyonggong
 * @since 2020-07-10
 */
@RestController
@RequestMapping
@Api(tags = {"分类：驿站管理"})
public class StationInfoController {
    
    @Autowired
    private IStationInfoService stationInfoService;

    @ApiOperation(value = "新增驿站信息", notes = "新增驿站信息")
    @PostMapping(StationUrlConstant.ADD)
    public GlobalResult add(@Valid @RequestBody StationInfoEditDTO dto) throws VerificationException {
        return stationInfoService.add(dto);
    }

    @ApiOperation(value = "启用禁用驿站信息", notes = "启用禁用驿站信息")
    @PostMapping(StationUrlConstant.ENABLE)
    public GlobalResult enableDisable(@RequestParam Integer id, @RequestParam Integer state) {
        return stationInfoService.enableDisable(id, state);
    }

    @ApiOperation(value = "按照id查询驿站", notes = "按照id查询驿站")
    @PostMapping(StationUrlConstant.SEARCH)
    public GlobalResult selectById(@RequestParam Integer id) {
        return stationInfoService.selectById(id);
    }

    @ApiOperation(value = "更新驿站信息", notes = "更新驿站信息")
    @PostMapping(StationUrlConstant.UPDATE)
    public GlobalResult update(@Valid @RequestBody StationInfoEditDTO dto) throws VerificationException {
        return stationInfoService.edit(dto);
    }

    @ApiOperation(value = "条件查询驿站", notes = "条件查询驿站")
    @PostMapping(StationUrlConstant.SEARCH_LIST)
    public GlobalResult selectByConditions(@Valid @RequestBody StationInfoSearchDTO dto) {
        return stationInfoService.selectByConditions(dto);
    }
}

