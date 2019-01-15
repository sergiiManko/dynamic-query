package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import com.mentor.jpa.dynamicquery.repository.DepartmentRepository;
import com.mentor.jpa.dynamicquery.specification.DepartmentSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Manko
 */
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(final DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDynamicSearch(final List<SearchData> searchDataList) {
        List<Department> result = new ArrayList<>();
        Specification<Department> specification = new DepartmentSpecification();
        if (searchDataList != null) {
            for (SearchData searchData : searchDataList) {
                specification = Specification.where(specification).and(new DepartmentSpecification(searchData));
            }
            result = departmentRepository.findAll(specification);
        }
        return result;
    }
}
