package com.pageNation.pagenationdata.dto;

import com.pageNation.pagenationdata.entity.Department;
import com.pageNation.pagenationdata.enums.Designation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class EmployeeDto {
    private  Long id;
    private  String name;
    private  int age;
    private  String city;

    private  String phoneNumber;
    private Float salary ;
    private DepartmentDto departmentDto;

    private Designation designation;



}
