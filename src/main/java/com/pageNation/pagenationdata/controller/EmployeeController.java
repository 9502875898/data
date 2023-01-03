package com.pageNation.pagenationdata.controller;

import com.pageNation.pagenationdata.dto.EmployeeDto;
import com.pageNation.pagenationdata.dto.PagenationDto;
import com.pageNation.pagenationdata.entity.Employee;
import com.pageNation.pagenationdata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/save")
    public Object save(@RequestBody EmployeeDto employeeDto){
        employeeService.save(employeeDto);
        return "save success";
    }
    @PostMapping("/save/page")
    public List<EmployeeDto>getPageNation(@RequestBody PagenationDto pagenationDto){
        return employeeService.getPageNation(pagenationDto);

    }
    @GetMapping("/get")
    public List<EmployeeDto>getAll(){
        return  employeeService.getAll();
    }
    @PutMapping("/put")
    public Object update(@RequestBody  EmployeeDto employeeDto){
       return employeeService.update(employeeDto);


}
}
