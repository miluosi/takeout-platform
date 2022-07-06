package com.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.order.common.lang.Result;
import com.order.entity.Goods;
import com.order.entity.Table;
import com.order.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/table")
public class TableController {
    @Autowired
    TableService tableService;

    @GetMapping("/list")
    @ResponseBody
    public Result detail() {
        QueryWrapper<Table> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("ifoccupied", 0);
        List<Table> questions = tableService.list(sectionQueryWrapper);
        System.out.println(questions.size());
        Assert.notNull(questions, "信息已被删除");
        System.out.println(questions);
        return Result.succ(questions);
    }

}
