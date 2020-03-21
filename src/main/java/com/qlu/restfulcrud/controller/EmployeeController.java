package com.qlu.restfulcrud.controller;

import com.qlu.restfulcrud.dao.DepartmentDao;
import com.qlu.restfulcrud.dao.EmployeeDao;
import com.qlu.restfulcrud.entities.Department;
import com.qlu.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author jiajinshuo
 * @create 2020-02-08 20:55
 */
//处理和员工相关的请求
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面。这个emps在bar.xml中
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放到请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到员工添加页面,查出所有的部门，在页面上显示，就要写model
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存的员工信息"+employee);
        //保存员员工
        employeeDao.save(employee);
        //重定向到当前项目的/emps./指的是当前项目路径
        return "redirect:/emps";
    }
    //来到修改页面，查出员工，再回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        //查出员工并保存
        model.addAttribute("emp",employee);
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面.add是一个修改添加二合一的页面
        return "emp/add";

    }
    //员工修改。需要修改员工的id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){//携带了员工数据
        System.out.println("员工数据"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工删除
    @PostMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
