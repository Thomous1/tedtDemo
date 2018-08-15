package com.bonc.service;

import com.bonc.domain.Data;
import com.bonc.domain.Department;
import com.bonc.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by 王小浪 on 2018/5/23.
 */

public interface EmployeeService {
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
