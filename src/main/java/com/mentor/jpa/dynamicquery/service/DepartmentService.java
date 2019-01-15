package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import com.mentor.jpa.dynamicquery.repository.DepartmentRepository;
import com.mentor.jpa.dynamicquery.specification.DepartmentSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartmentBySearchData(final List<SearchData> searchDataList) {
        List<Department> result = new ArrayList<>();
        Specification<Department> specification = new DepartmentSpecification();
        if (searchDataList != null) {
            for (SearchData searchData : searchDataList) {
                specification = Specification.where(new DepartmentSpecification(searchData));
            }
            result = departmentRepository.findAll(specification);
        }
        return result;
    }
}
