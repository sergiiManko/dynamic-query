package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import com.mentor.jpa.dynamicquery.repository.DepartmentRepository;
import com.mentor.jpa.dynamicquery.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nikita Blizniukov
 */
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(final DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDynamicSearch(List<SearchData> searchDataList) {
        Specification<Department> specification = new DepartmentSpecification();

        for (SearchData searchData : searchDataList) {
            specification = Specification.where(specification).and(new DepartmentSpecification(searchData));
        }

        return departmentRepository.findAll(specification);
    }
}
