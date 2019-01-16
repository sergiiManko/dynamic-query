package com.mentor.jpa.dynamicquery.controller;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.core.SearchDataDepartment;
import com.mentor.jpa.dynamicquery.core.SearchDataEmployee;
import com.mentor.jpa.dynamicquery.domain.Employee;
import com.mentor.jpa.dynamicquery.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Employee>> getEmployeeSearch() {
        List<SearchData> searchDataList = new ArrayList<>();
        searchDataList.add(new SearchDataDepartment("code", "001"));
        searchDataList.add(new SearchDataEmployee("name", "Ivan"));
        return new ResponseEntity<>(employeeService.getEmployeeBySearchData(searchDataList), HttpStatus.OK);
    }
}
