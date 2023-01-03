package com.pageNation.pagenationdata.service;

import com.pageNation.pagenationdata.dto.EmployeeDto;
import com.pageNation.pagenationdata.dto.PagenationDto;

import java.util.List;

public interface EmployeeService {
    void save(EmployeeDto employeeDto);

    List<EmployeeDto> getPageNation(PagenationDto pagenationDto);

    List<EmployeeDto> getAll();

    Object update(EmployeeDto employeeDto);
}
