package com.mentor.jpa.dynamicquery.controller;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Employee;
import com.mentor.jpa.dynamicquery.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Blizniukov
 */
@RestController
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        final List<SearchData> searchDataList = new ArrayList<>();
        searchDataList.add(new SearchData("code", "01"));
        return employeeService.getDynamicEmployeeSearch(searchDataList);
    }
}
