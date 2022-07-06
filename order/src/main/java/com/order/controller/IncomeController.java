package com.order.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.order.common.lang.Result;
import com.order.entity.Customer;
import com.order.entity.Income;
import com.order.entity.Record;
import com.order.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mz
 * @since 2021-11-24
 */
@RestController
@RequestMapping("/income")
public class IncomeController {



    @Autowired
    IncomeService incomeService;



    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/list")
    @ResponseBody
    public Result detail() {
        List<Income> questions = incomeService.list();
        System.out.println(questions.size());
        Assert.notNull(questions, "信息已被删除");
        return Result.succ(questions);
    }



    @PostMapping("/add")
    public Result add(@Validated @RequestBody Income income) {
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 0);//如果把0修改为-1就代表昨天
        date = calendar.getTime();
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(date);
        income.setDate(dateString);
        System.out.println(dateString);
        incomeService.save(income);
        return Result.succ(MapUtil.builder()
                .put("msg", "success")
                .put("id", income.getId())
                .map()
        );
    }


    @GetMapping("/detail/{customerid}")
    @ResponseBody
    public Result check(@PathVariable(name = "customerid") Integer customerid) {
        String check = "select name,price,num from m_record t1 LEFT JOIN m_goods  t2 on(t1.cuisineid = t2.id)  where customerid = "+customerid+"";
        List<Map<String,Object>>result=jdbcTemplate.queryForList(check);
        return Result.succ(MapUtil.builder()
                .put("result", result)
                .map()
        );
    }


    @GetMapping("/info")
    @ResponseBody
    public Result check() {
        String check = "select sum(income) income ,any_value(date) date from m_income GROUP BY date_format(date, '%Y-%m-%d')";
        List<Map<String,Object>>result=jdbcTemplate.queryForList(check);
        System.out.println(result);
        return Result.succ(MapUtil.builder()
                .put("result", result)
                .map()
        );
    }

}
