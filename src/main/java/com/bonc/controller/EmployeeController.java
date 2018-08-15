package com.bonc.controller;


import com.bonc.domain.Data;
import com.bonc.domain.Department;
import com.bonc.domain.Employee;
import com.bonc.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 王小浪 on 2018/5/23.
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

@RequestMapping("/getid/{empId}")
    public String getEmpById(@PathVariable String empId , Model model){
    System.out.println(empId);
        Employee employee= employeeService.getEmpById(Integer.parseInt(empId));
        System.out.println(employee);
        model.addAttribute("employee",employee);
        return "edit";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/getTableData",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Employee> getTableData(@RequestParam Map<String, Object> params){
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        int pageNumber = Integer.parseInt((String) params.get("pageNumber"));
        PageHelper.startPage(pageNumber,pageSize);
        List<Employee> empList = employeeService.findAll();
        PageInfo<Employee> empinfo = new PageInfo<>(empList);
        System.out.println(empinfo);
        List<Department> deptList = employeeService.findAllDept();
         return empinfo;
    }

@RequestMapping("findAll")
    public String findAll(Model model){
    PageHelper.startPage(1,10);
    List<Employee> empList = employeeService.findAll();
    PageInfo<Employee> empinfo = new PageInfo<>(empList);
    System.out.println(empinfo);
    List<Department> deptList = employeeService.findAllDept();
    System.out.println(empList.get(0).getEmpId());
    model.addAttribute("empinfo",empinfo);
    model.addAttribute("empList",empList);
    model.addAttribute("deptList",deptList);
    return "index";
    }
    @RequestMapping("insertEmp")
    @ResponseBody
    public String insertEmp(@RequestParam Map<String,Object> map){
        Employee employee = new Employee();
        employee.setEmpEmail((String)map.get("empEmail"));
        employee.setEmpGender((String)map.get("empGender"));
        employee.setEmpName((String)map.get("empName"));
        String deptId = (String) map.get("empDept");
        Department dept = employeeService.getDeptById(Integer.parseInt(deptId));
        employee.setDept(dept);
        System.out.println(employee);
        employeeService.insertEmp(employee);
        return "1";
    }

    @RequestMapping("insertDept")
    @ResponseBody
    public String insertDept(@RequestParam Map<String,Object> map){
        Department department = new Department();
       department.setDeptName((String) map.get("deptname"));
        employeeService.insertDept(department);
        return "1";
    }

    @RequestMapping("delEmp")
    @ResponseBody
    public String delEmp(@RequestParam Map<String,Object> map){
        String empId =(String) map.get("empId");
        employeeService.delEmp(Integer.parseInt(empId));
        return "1";
    }
    @RequestMapping("updateEmp")
    @ResponseBody
    public Employee updateEmp(Model model,
                              @RequestParam Map<String,Object> map){
        String empId =(String) map.get("empId");
        Employee employee = employeeService.getEmpById(Integer.parseInt(empId));
        model.addAttribute("employee",employee);
        return employee;
    }
    @RequestMapping("updateSubEmp")
    @ResponseBody
    public String updateSubEmp(
                            @RequestParam Map<String,Object> map){
        Employee employee = new Employee();
        String empId =(String) map.get("empId");
        employee.setEmpId(Integer.parseInt(empId));
        employee.setEmpEmail((String)map.get("empEmail"));
        employee.setEmpGender((String)map.get("empGender"));
        employee.setEmpName((String)map.get("empName"));
        String deptId = (String) map.get("empDept");
        Department dept = employeeService.getDeptById(Integer.parseInt(deptId));
        employee.setDept(dept);
        System.out.println(employee);
        employeeService.updateEmp(employee);
        return "1";
    }

    @RequestMapping("goPage/{pageNum}")
    public String goPage(Model model,@PathVariable Integer pageNum){
        System.out.println(pageNum);
        PageHelper.startPage(pageNum,10);
        List<Employee> empList = employeeService.findAll();
        PageInfo<Employee> empinfo = new PageInfo<>(empList);
        System.out.println(empinfo);
        List<Department> deptList = employeeService.findAllDept();
        int arr[] = {pageNum-2,pageNum-1,pageNum,pageNum+1,pageNum+2};
        int arr2[] = {pageNum-3,pageNum-2,pageNum-1,pageNum,pageNum+1};
        int arr3[] = {pageNum-4,pageNum-3,pageNum-2,pageNum-1,pageNum};
        if(empinfo.getNavigatepageNums().length>5&&pageNum>=3&&pageNum<=empinfo.getNavigatepageNums().length-2){
            empinfo.setNavigatepageNums(arr);
        }else if(pageNum==empinfo.getNavigatepageNums().length-1){
            empinfo.setNavigatepageNums(arr2);
        }else if(pageNum==empinfo.getNavigatepageNums().length){
            empinfo.setNavigatepageNums(arr3);
        }
        model.addAttribute("empinfo",empinfo);
        model.addAttribute("empList",empList);
        model.addAttribute("deptList",deptList);
        return "index";
    }

    @RequestMapping("/getData")
    @ResponseBody
    public List<Data> getData() {
        List<Data> list = employeeService.getData();
        System.out.println(list.size());
        return list;
    }
    @RequestMapping(value = "/getDataByName",method = RequestMethod.POST)
    @ResponseBody
    public Employee getDataByName(@RequestBody String name) {

        Employee emp = employeeService.getDataByName(name);
        return emp;
    }



}
