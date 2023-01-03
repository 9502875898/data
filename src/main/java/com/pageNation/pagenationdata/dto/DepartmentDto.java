package com.pageNation.pagenationdata.dto;

import com.pageNation.pagenationdata.entity.Employee;
import com.pageNation.pagenationdata.enums.Designation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Setter
@Getter
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    private  String  deptName;

    private String OfficeTimes;
    private EmployeeDto employeeDto;

    private Designation designation;
}
