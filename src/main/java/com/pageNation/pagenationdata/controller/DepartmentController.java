package com.pageNation.pagenationdata.controller;

import com.pageNation.pagenationdata.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
}
