package com.changgou.goods.dao;

import com.changgou.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

/**
 * 品牌接口
 * Dao 接口类中无须写东西,因为Mapper的回调会帮我们把方法都写好
 * Mapper 模板,需传递需要操作的的实体类
 */
public interface BrandMapper  extends Mapper<Brand> {
    // 查询全部品牌
    // 根据品牌id查询品牌信息
    // 插入一个品牌信息 传递 需要插入品牌的 json 数据就行了
    // 修改一个品牌信息
    // 需要传入要修改数据的id 和修改后的品牌信息数据
    // 删除品牌 deleteByPrimaryKey
    // 按条件查询 数据

    // 品牌列表分页查询

}
