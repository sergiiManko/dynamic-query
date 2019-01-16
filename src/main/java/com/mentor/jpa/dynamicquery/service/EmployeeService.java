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

    public List<Employee> getDynamicEmployeeSearch(List<SearchData> searchDataList) {
        List<Employee> employeesList = new ArrayList<>();
        Specification<Employee> specification = new EmployeeSpecification();
        if (searchDataList != null) {
            for (SearchData data : searchDataList) {
                specification = Specification.where(specification).and(new EmployeeSpecification(data));
            }
            employeesList = employeeRepository.findAll(specification);
            return employeesList;
        }
        return employeesList;
    }
}
