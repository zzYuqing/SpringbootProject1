package com.yoyo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yoyo.mapper.EmpMapper;
import com.yoyo.pojo.Emp;
import com.yoyo.pojo.PageBean;
import com.yoyo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public PageBean listEmp(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
////        String name, Short gender, LocalDate begin,LocalDate end,Integer page,Integer pageSize
//        if (page==null)
//            page=1;
//        if(pageSize==null)
//            pageSize=10;
//        page=(page-1)*pageSize;
//        List<Emp> empList=empMapper.listEmp(name,gender,begin,end,page,pageSize);
//        Long total=(long)empMapper.countEmp();
//        PageBean pageBean=new PageBean(total,empList);
//        return pageBean;
//    }
    @Override
    public PageBean listEmp(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
    //        String name, Short gender, LocalDate begin,LocalDate end,Integer page,Integer pageSize

//        设置分页参数
        PageHelper.startPage(page,pageSize);
//        执行查询
//        List<Emp> empList=empMapper.listEmp(name,gender,begin,end,page,pageSize);
        List<Emp> empList=empMapper.list(name,gender,begin,end);
        Page<Emp> empPage=(Page<Emp>) empList;


        PageBean pageBean=new PageBean(empPage.getTotal(),empPage.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp select(Integer id) {
        Emp emp=empMapper.select(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        Emp e=empMapper.getByUsernameAndPassword(emp);
        return e;
    }
}
