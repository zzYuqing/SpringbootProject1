package com.yoyo.controller;

import com.yoyo.pojo.Emp;
import com.yoyo.pojo.PageBean;
import com.yoyo.pojo.Result;
import com.yoyo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result list(String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){

        PageBean pageBean=empService.listEmp(name,gender,begin,end,page,pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Emp emp)
    {
        empService.insert(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Emp emp=empService.select(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
}
