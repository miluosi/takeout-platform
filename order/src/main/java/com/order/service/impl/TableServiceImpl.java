package com.order.service.impl;

import com.order.entity.Table;
import com.order.mapper.TableMapper;
import com.order.service.TableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mz
 * @since 2021-11-23
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements TableService {

}
