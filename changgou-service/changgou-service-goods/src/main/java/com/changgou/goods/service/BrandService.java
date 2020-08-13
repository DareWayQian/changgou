package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<Brand> findAll();
    public Brand findById(Integer id);
    public int add(Brand brand);
    public int update(Brand brand);
    public int delete(Integer id);
    // 多条件搜索品牌数据
    public List<Brand> findList(Map<String,Object> searchMap);

    /**
     * 分页查询 , 查询第几页,每页的大小
     * @param page
     * @param size
     * @return
     */
    public Page<Brand> findPage(int page, int size);
}
