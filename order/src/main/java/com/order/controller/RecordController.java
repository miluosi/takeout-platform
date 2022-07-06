package com.order.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.order.common.lang.Result;
import com.order.entity.Customer;
import com.order.entity.Goods;
import com.order.entity.Record;
import com.order.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mz
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/record")
public class RecordController {



    @Autowired
    RecordService recordService;



    @Autowired
    JdbcTemplate jdbcTemplate;



    @PostMapping("/add")
    public Result add(@Validated @RequestBody Record record) {
        System.out.println(record.getCustomerid());
        System.out.println(record.getCuisineid());
        System.out.println(record.getTableid());
        Integer cusineid = record.getCuisineid();
        Integer customerid = record.getCustomerid();
        QueryWrapper<Record> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("cuisineid", cusineid);
        sectionQueryWrapper.eq("customerid", customerid);
        List<Record> record1 = recordService.list(sectionQueryWrapper);
        System.out.println(record1);
        if(record1.size()==0){
            System.out.println("空");
            record.setNum(1);
            recordService.save(record);
        }else {
            Integer num = record1.get(0).getNum();
            System.out.println(num);
            record.setNum(num+1);
            record.setId(record1.get(0).getId());
            System.out.println(record.getId());
            recordService.updateById(record);
        }
        return Result.succ(MapUtil.builder()
                .put("id", record.getId())
                .map()
        );
    }



    @PostMapping("/delete")
    public Result delete(@Validated @RequestBody Record record) {
        System.out.println(record.getCustomerid());
        System.out.println(record.getCuisineid());
        System.out.println(record.getTableid());
        Integer cusineid = record.getCuisineid();
        Integer customerid = record.getCustomerid();
        QueryWrapper<Record> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("cuisineid", cusineid);
        sectionQueryWrapper.eq("customerid", customerid);
        List<Record> record1 = recordService.list(sectionQueryWrapper);
        System.out.println(record1);
        if(record1.size()==0){
            System.out.println("空");
            return Result.succ(MapUtil.builder()
                    .put("msg", "empty")
                    .map()
            );
        }else {
            Integer num = record1.get(0).getNum();
            Integer id = record1.get(0).getId();
            if(num==1){
                recordService.removeById(id);
                return Result.succ(MapUtil.builder()
                        .put("msg", "success")
                        .map()
                );
            }else {
                System.out.println(num);
                record.setNum(num-1);
                record.setId(record1.get(0).getId());
                System.out.println(record.getId());
                recordService.updateById(record);
                return Result.succ(MapUtil.builder()
                        .put("id", record.getId())
                        .map()
                );
            }
        }
    }



    @GetMapping("/check/{customerid}")
    @ResponseBody
    public Result check(@PathVariable(name = "customerid") Integer customerid) {
        String check = "select t1.customerid cid,name,num,price from m_record t1   LEFT JOIN m_goods t2 on( t1.cuisineid = t2.id) WHERE t1.customerid = "+customerid+"";
        List<Map<String,Object>>result=jdbcTemplate.queryForList(check);
        System.out.println(result);
        float sum = 0;
        for(int i=0;i<result.size();i++)
        {
            sum+=Float.valueOf(result.get(i).get("price").toString())*Float.valueOf(result.get(i).get("num").toString());
        }
        System.out.println(sum);
        return Result.succ(MapUtil.builder()
                .put("result", result)
                .put("sum", sum)
                .map()
        );
    }

}
