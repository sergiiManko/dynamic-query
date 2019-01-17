package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.core.SearchDataDepartment;
import com.mentor.jpa.dynamicquery.core.SearchDataEmployee;
import com.mentor.jpa.dynamicquery.domain.Employee;
import com.mentor.jpa.dynamicquery.repository.EmployeeRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
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
        Specification<Employee> specification;
        if (searchDataList != null) {
            specification = Specification.where((Specification<Employee>) (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                for (SearchData searchData : searchDataList) {
                    if (searchData instanceof SearchDataEmployee) {
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(searchData.getFieldName()).as(String.class)),
                                "%" + searchData.getValue().trim().toLowerCase() + "%"));
                    }

                    if (searchData instanceof SearchDataDepartment) {
                        SearchDataDepartment searchDataDepartment = (SearchDataDepartment) searchData;
                        predicates.add(criteriaBuilder
                                .like(root.join(searchDataDepartment.getNameTable())
                                                .get(searchData.getFieldName()).as(String.class),
                                        "%" + searchData.getValue().trim().toLowerCase() + "%"));
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            });
            result = employeeRepository.findAll(specification);
        }
        return result;
    }
}
