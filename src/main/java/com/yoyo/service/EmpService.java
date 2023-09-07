package com.yoyo.service;

import com.yoyo.pojo.Emp;
import com.yoyo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    public PageBean listEmp(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    public void delete(List<Integer> ids);

    public void insert(Emp emp);

    public Emp select(Integer id);

    public void update(Emp emp);

    Emp login(Emp emp);

}
