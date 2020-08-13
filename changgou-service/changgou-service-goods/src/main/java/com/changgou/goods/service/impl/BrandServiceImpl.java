package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 创建service 和 controller 一定不要忘记加上注解,表示被spring容器扫描,被使用
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;
    /*
    * serviceImpl 实现,获取数据出问题了,原因是接口定义与实现返回值类型不匹配
    */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Brand brand) {
        /*
            有选择的插入数据,如果数据项为空,则跳过
        */
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int delete(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }
    // 业务类传递过来查询条件后,是否需要处理参数,如何处理参数的问题
    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        // Criteria 标准 Example 例子
        Example.Criteria criteria = example.createCriteria();
        if(searchMap.get("name") != null && !"".equals(searchMap.get("name"))){
            criteria.andLike("name","%"+searchMap.get("name")+"%");
        }
        if(searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))){
            criteria.andEqualTo("letter",searchMap.get("letter"));
        }
        return brandMapper.selectByExample(example);
    }

    @Override
    public Page<Brand> findPage(int page, int size) {

        PageHelper.startPage(page,size);
        return (Page<Brand>) brandMapper.selectAll();

    }
}
