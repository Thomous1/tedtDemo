package com.bonc.service.impl;

        import com.bonc.dao.EmployeeDao;
        import com.bonc.domain.Data;
        import com.bonc.domain.Department;
        import com.bonc.domain.Employee;
        import com.bonc.service.EmployeeService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Map;

/**
 * Created by 王小浪 on 2018/5/23.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee getEmpById(Integer id) {
        return employeeDao.getEmpById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Department getDeptById(Integer id) {
        return employeeDao.getDeptById(id);
    }

    @Override
    public void insertEmp(Employee employee) {
        employeeDao.insertEmp(employee);
    }

    @Override
    public Department findDeptByName(String name) {
        return employeeDao.findDeptByName(name);
    }

    @Override
    public List<Department> findAllDept() {
        return employeeDao.findAllDept();
    }

    @Override
    public void insertDept(Department department) {
        employeeDao.insertDept(department);
    }

    @Override
    public void delEmp(Integer id) {
        employeeDao.delEmp(id);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
    }

    @Override
    public List<Data> getData() {
        return employeeDao.getData();
    }

    @Override
    public Employee getDataByName(String name) {
        return employeeDao.getDataByName(name);
    }
}
