package com.mentor.jpa.dynamicquery.controller;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import com.mentor.jpa.dynamicquery.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Manko
 */
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(final DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment() {
        final List<SearchData> searchDataList = new ArrayList<>();
        searchDataList.add(new SearchData("code", "00"));
        searchDataList.add(new SearchData("unit", "not"));
        return departmentService.getDynamicSearch(searchDataList);
    }
}
