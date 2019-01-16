package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Employee;
import com.mentor.jpa.dynamicquery.repository.EmployeeRepository;
import com.mentor.jpa.dynamicquery.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Blizniukov
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getDynamicEmployeeSearch(SearchData searchData) {
        List<Employee> employeesList = new ArrayList<>();
        if (searchData != null) {
            Specification<Employee> spec = new EmployeeSpecification(searchData);
            employeesList = employeeRepository.findAll(spec);
            return employeesList;
        }
        return employeesList;
    }
}
