package com.bonc.dao;


import com.bonc.domain.Department;
import com.bonc.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import com.bonc.domain.Data;
import java.util.List;


@Mapper
public interface EmployeeDao {
    Employee getEmpById(Integer id);

    List<Employee> findAll();

    Department getDeptById(Integer id);

    void insertEmp(Employee employee);

    Department findDeptByName(String name);

    List<Department> findAllDept();

    void insertDept(Department department);

    void delEmp(Integer id);

    void updateEmp(Employee employee);

    List<Data> getData();

    Employee getDataByName(String name);
}
