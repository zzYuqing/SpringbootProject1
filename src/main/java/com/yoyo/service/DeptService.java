package com.yoyo.service;

import com.yoyo.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> listDept();
    public void deleteDept(Integer id);

    public void insertDept(Dept dept);

    public Dept getById(Integer id);

    public void update(Dept dept);
}
