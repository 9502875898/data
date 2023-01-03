package com.pageNation.pagenationdata.service.impl;

import com.pageNation.pagenationdata.repo.DepartmentRepository;
import com.pageNation.pagenationdata.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
}
