package com.bonc.service;

import com.bonc.domain.Data;
import com.bonc.domain.Department;
import com.bonc.domain.Employee;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * Created by 王小浪 on 2018/5/23.
 * desc :
 *      @CacheConfig：该注解是用来开启声明的类参与缓存,
 *      如果方法内的@Cacheable注解没有添加key值，
 *      那么会自动使用cahceNames配置参数并且追加方法名。
 *      @Cacheable：配置方法的缓存参数，可自定义缓存的key以及value。
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
