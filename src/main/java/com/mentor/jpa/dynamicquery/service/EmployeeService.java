package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Employee;
import com.mentor.jpa.dynamicquery.repository.EmployeeRepository;
import com.mentor.jpa.dynamicquery.specification.EmployeeSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Kudria
 */
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeBySearchData(final List<SearchData> searchDataList) {
        List<Employee> result = new ArrayList<>();
        Specification<Employee> specification = new EmployeeSpecification();
        if (searchDataList != null) {
            for (SearchData searchData : searchDataList) {
                specification = Specification.where(new EmployeeSpecification(searchData));
            }
            result = employeeRepository.findAll(specification);
        }
        return result;
    }
}
