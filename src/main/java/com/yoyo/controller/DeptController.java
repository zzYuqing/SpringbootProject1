package com.yoyo.controller;

import com.yoyo.pojo.Dept;
import com.yoyo.pojo.Result;
import com.yoyo.service.DeptService;
import com.yoyo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList=deptService.listDept();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        deptService.deleteDept(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("根据名称添加新的部门");
        deptService.insertDept(dept);
        return Result.success();

    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查信息");
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门数据:{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
