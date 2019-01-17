package com.mentor.jpa.dynamicquery.controller;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import com.mentor.jpa.dynamicquery.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = {"api/department"})
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Department>> getDepartment() {
        List<SearchData> searchDataList = new ArrayList<>();
        searchDataList.add(new SearchData("code", "002"));
        searchDataList.add(new SearchData("unit", "not"));
        return new ResponseEntity<>(departmentService.getAllDepartmentBySearchData(searchDataList), HttpStatus.OK);
    }
}
