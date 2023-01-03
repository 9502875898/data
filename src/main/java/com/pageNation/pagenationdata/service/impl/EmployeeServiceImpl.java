package com.pageNation.pagenationdata.service.impl;

import com.pageNation.pagenationdata.dto.DepartmentDto;
import com.pageNation.pagenationdata.dto.EmployeeDto;
import com.pageNation.pagenationdata.dto.PagenationDto;

import com.pageNation.pagenationdata.entity.Department;
import com.pageNation.pagenationdata.entity.Employee;
import com.pageNation.pagenationdata.repo.DepartmentRepository;
import com.pageNation.pagenationdata.repo.EmployeeRepository;
import com.pageNation.pagenationdata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setCity(employeeDto.getCity());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());

        employee.setSalary(employeeDto.getSalary());
        Department department = new Department();
        DepartmentDto departmentDto = new DepartmentDto();
        department.setDeptName(employeeDto.getDepartmentDto().getDeptName());
        department.setDesignation(employeeDto.getDepartmentDto().getDesignation());
        department.setOfficeTimes(employeeDto.getDepartmentDto().getOfficeTimes());
        employee.setDepartment(department);
        employeeRepository.save(employee);

    }

    @Override
    public List<EmployeeDto> getPageNation(PagenationDto pagenationDto) {

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        if (pagenationDto.getPageNumber() >= 0 && pagenationDto.getPageSize() >= 0) {
            Pageable pageable = PageRequest.of(pagenationDto.getPageNumber(), pagenationDto.getPageSize());
            Page<Employee> employeePage = employeeRepository.findAll(pageable);//top Down

            if (employeePage != null && employeePage.getContent() != null) {
                for (Employee employee : employeePage) {
                    EmployeeDto employeeDto = new EmployeeDto();
                    employeeDto.setName(employee.getName());
                    employeeDto.setAge(employee.getAge());
                    employeeDto.setCity(employee.getCity());
                    employeeDto.setPhoneNumber(employee.getPhoneNumber());

                    employee.setSalary(employeeDto.getSalary());
                    employeeDtos.add(employeeDto);

                   /* List<DepartmentDto>departmentDtoList=new ArrayList<>();
                    List<Department>list=departmentRepository.findAll();*/
                    // for (Department department1 :list ){
                    Department department1 = new Department();
                    DepartmentDto departmentDto = new DepartmentDto();
                    if (employeeDto.getDepartmentDto() != null) {
                        employeeDto.getDepartmentDto().setDeptName(department1.getDeptName());
                        employeeDto.getDepartmentDto().setDesignation(department1.getDesignation());
                        employeeDto.getDepartmentDto().setId(department1.getId());
                        employeeDto.getDepartmentDto().setOfficeTimes(department1.getOfficeTimes());
                        employeeDto.setDepartmentDto(departmentDto);
                    /*departmentDto.setOfficeTimes(department1.getOfficeTimes());
                    departmentDto.setId(department1.getId());
                    departmentDto.setDeptName(department1.getDeptName());
                    departmentDto.setDesignation(department1.getDesignation());*/



                   /* department.setDeptName(employeeDto.getDepartment().getDeptName());
                    department.setDesignation(employeeDto.getDepartment().getDesignation());
                    department.setOfficeTimes(employeeDto.getDepartment().getOfficeTimes());
                    employeeDto.setDepartment(department);*/

                        employeeDto.setDepartmentDto(departmentDto);
                        employeeDtos.add(employeeDto);
                    }
                }

            }
        }
        return employeeDtos;

    }

    @Override
    public List<EmployeeDto> getAll() {

        List<EmployeeDto>employeeDtos=new ArrayList<>();
        List<Employee>employeeList=employeeRepository.findAll();

        for (Employee employee:employeeList) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setName(employee.getName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setCity(employee.getCity());
            employeeDto.setPhoneNumber(employee.getPhoneNumber());
            employee.setSalary(employee.getSalary());
            List<DepartmentDto> departmentDtos = new ArrayList<>();
            List<Department> list = departmentRepository.findAll();
            for (Department department1 : list) {

                //Department department = new Department();
                DepartmentDto departmentDto = new DepartmentDto();
                departmentDto.setDeptName(department1.getDeptName());
                departmentDto.setDesignation(department1.getDesignation());
                departmentDto.setOfficeTimes(department1.getOfficeTimes());
                employeeDto.setDepartmentDto(departmentDto);
                employeeDtos.add(employeeDto);
            }
        }
        return employeeDtos;
    }

    @Override
    public Object update(EmployeeDto employeeDto) {
        return null;
    }
}


