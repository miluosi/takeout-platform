package com.order.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.order.common.dto.CusDto;
import com.order.common.lang.Result;
import com.order.entity.Admin;
import com.order.entity.Goods;
import com.order.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RelationSupport;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mz
 * @since 2021-11-24
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody Admin admin) {
        QueryWrapper<Admin> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("username", admin.getUsername());
        List<Admin> admins = adminService.list(sectionQueryWrapper);
        if(admins.size()==0){
            return Result.succ(MapUtil.builder()
                    .put("msg","用户名不存在")
                    .map()
            );
        }else {
            Admin admin1 = admins.get(0);
            if(admin.getPawd().equals(admin1.getPawd())){
                return Result.succ(MapUtil.builder()
                        .put("adminname",admin1.getUsername())
                        .put("pwd",admin1.getPawd())
                        .map());
            }else {
                return Result.succ(MapUtil.builder()
                        .put("msg","密码错误")
                        .map());
            }
        }
    }

}
