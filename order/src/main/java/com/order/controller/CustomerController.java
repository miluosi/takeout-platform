package com.order.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.order.common.dto.CusDto;
import com.order.common.lang.Result;
import com.order.entity.Customer;
import com.order.entity.Table;
import com.order.mapper.CustomerMapper;
import com.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    @ResponseBody
    public Result detail() {
        List<Customer> questions = customerService.list();
        System.out.println(questions.size());
        Assert.notNull(questions, "信息已被删除");
        return Result.succ(questions);
    }


    @GetMapping("/num")
    @ResponseBody
    public Result detail1() {
        List<Customer> questions = customerService.list();
        int num = questions.size();
        Assert.notNull(questions, "信息已被删除");
        return Result.succ(MapUtil.builder()
                .put("num", num)
                .map()
        );
    }


    @PostMapping("/add")
    public Result login(@Validated @RequestBody CusDto cusDto) {
        System.out.println(cusDto.getTableid());
        String insert = "INSERT INTO m_customer (id,tableid)   VALUES ("+cusDto.getId()+","+cusDto.getTableid()+")";
        System.out.println(insert);
        jdbcTemplate.update(insert);
        return Result.succ(MapUtil.builder()
                .put("id",cusDto.getId() )
                .put("tableid",cusDto.getTableid())
                .map()
        );
    }
}
