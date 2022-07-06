package com.order.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.order.common.lang.Result;
import com.order.entity.Goods;
import com.order.entity.Record;
import com.order.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mz
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/list")
    @ResponseBody
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = goodsService.page(page, new QueryWrapper<Goods>().orderByAsc("id"));
        return Result.succ(pageData);
    }

    @GetMapping("/hamlist")
    @ResponseBody
    public Result detail() {
        QueryWrapper<Goods> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("type", "汉堡");
        List<Goods> questions = goodsService.list(sectionQueryWrapper);
        Assert.notNull(questions, "信息已被删除");
        System.out.println(questions);
        return Result.succ(questions);
    }

    @GetMapping("/yinliaolist")
    @ResponseBody
    public Result detail1() {
        QueryWrapper<Goods> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("type", "饮料");
        List<Goods> questions = goodsService.list(sectionQueryWrapper);
        Assert.notNull(questions, "信息已被删除");
        return Result.succ(questions);
    }

    @GetMapping("/xiaoshilist")
    @ResponseBody
    public Result detail2() {
        QueryWrapper<Goods> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("type", "小食");
        List<Goods> questions = goodsService.list(sectionQueryWrapper);
        Assert.notNull(questions, "信息已被删除");
        return Result.succ(questions);
    }


    @GetMapping("/taocanlist")
    @ResponseBody
    public Result detail3() {
        QueryWrapper<Goods> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("type", "套餐");
        List<Goods> questions = goodsService.list(sectionQueryWrapper);
        Assert.notNull(questions, "信息已被删除");
        return Result.succ(questions);
    }


    @GetMapping("/getgoods/{id}")
    @ResponseBody
    public Result detail(@PathVariable(name = "id") Integer id) {
        QueryWrapper<Goods> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("id", id);
        List<Goods> questions = goodsService.list(sectionQueryWrapper);
        Assert.notNull(questions, "信息已被删除");
        return Result.succ(questions);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody Goods goods) {

        Goods good = goodsService.getOne(new QueryWrapper<Goods>().eq("id", goods.getId()));
        good.setName(goods.getName());
        good.setPrice(goods.getPrice());
        good.setSrc(goods.getSrc());
        good.setType(goods.getType());
        good.setDescription(goods.getDescription());
        goodsService.updateById(good);
        return Result.succ(MapUtil.builder()
                .put("id", good.getId())
                .map()
        );
    }


    @PostMapping("/add")
    public Result add(@Validated @RequestBody Goods goods) {
        goodsService.save(goods);
        return Result.succ(MapUtil.builder()
                .put("msg", "success")
                .put("id", goods.getId())
                .map()
        );
    }


    @GetMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable(name = "id") Integer id) {
        goodsService.removeById(id);
        return Result.succ(MapUtil.builder()
                .put("id", id)
                .put("msg", "delete success")
                .map()
        );
    }

}
