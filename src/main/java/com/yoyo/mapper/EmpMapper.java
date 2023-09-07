package com.yoyo.mapper;

import com.yoyo.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//        public List<Emp> listEmp(String name, Short gender, LocalDate begin,LocalDate end,Integer page,Integer pageSize);
//
//        public Integer countEmp();


    /**
     * 员工信息查询
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    public void delete(List<Integer> ids);

    /**
     * 添加员工
     * @param emp
     */
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    public void insert(Emp emp);

    /**
     * 根据id查找员工
     * @param id
     * @return
     */
    @Select("select * from emp where id=#{id}")
    Emp select(Integer id);


    void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据部门id删除所有对应员工
     * @param deptId
     */
    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);
}
