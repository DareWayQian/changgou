package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.Page;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/*
    开启 controller 响应
*/
@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> all = brandService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",all);
    }
    @GetMapping("/{id}")
    /*
    *  @RequestParam 和 @PathVariable 的区别
    */
    public Result<Brand> findById(@PathVariable Integer id){
        Brand singleBrand = brandService.findById(id);
        return new Result(true, StatusCode.OK,"查询单个品牌成功",singleBrand);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        int num = brandService.add(brand);
        return new Result(true,StatusCode.OK,"成功插入数据"+num+"条");
    }
    @PostMapping("/update/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable Integer id){
        brand.setId(id);
        int num = brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改数据数据"+num+"条");
    }
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        int num = brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除数据成功,删除"+num+"条");

    }
    /***
      * 多条件搜索品牌数据
      * @param searchMap
      * @return
      */
    @GetMapping("/select")
    public Result<List<Brand>> findList(@RequestParam  Map searchMap){
        List<Brand> list = brandService.findList(searchMap);
        return new Result(true,StatusCode.OK,"按条件查询数据成功",list);
    }
    /**
     * 查询分页的品牌数据
     */
    @GetMapping("/search/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size){
        Page<Brand> pageList = brandService.findPage(page, size);
        PageResult pageResult = new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"分页查询数据,查询成功",pageResult);
    }
}
