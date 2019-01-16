package com.mentor.jpa.dynamicquery.controller;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Employee;
import com.mentor.jpa.dynamicquery.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Kudria
 */
@RestController
@RequestMapping(value = {"/api/employee"})
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getEmployeeSearch() {
        List<SearchData> searchDataList = new ArrayList<>();
        searchDataList.add(new SearchData("code", "001"));
        searchDataList.add(new SearchData("name", "Ivan"));
        return employeeService.getEmployeeBySearchData(searchDataList);
    }
}
