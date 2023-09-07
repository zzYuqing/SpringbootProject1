package com.yoyo.mapper;

import com.yoyo.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    public List<Dept> listDept();
    public void deleteDept(Integer id);

    public void insertDept(Dept dept);

    public Dept getById(Integer id);

    public void updateDept(Dept dept);
}
