package com.order.mapper;

import com.order.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mz
 * @since 2021-11-23
 */
@Mapper
@Component
public interface CustomerMapper extends BaseMapper<Customer> {

}
