package com.yoyo.service.impl;

import com.yoyo.mapper.DeptMapper;
import com.yoyo.mapper.EmpMapper;
import com.yoyo.pojo.Dept;
import com.yoyo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> listDept() {
        List<Dept> deptList=deptMapper.listDept();
        return deptList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteDept(id);
        empMapper.deleteByDeptId(id);//将当前部门的所有员工都删除
    }
    @Override
    public void insertDept(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertDept(dept);
    }

    @Override
    public Dept getById(Integer id) {
        Dept dept=deptMapper.getById(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
}
