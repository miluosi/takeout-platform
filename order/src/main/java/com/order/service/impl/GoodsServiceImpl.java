package com.order.service.impl;

import com.order.entity.Goods;
import com.order.mapper.GoodsMapper;
import com.order.service.GoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}
