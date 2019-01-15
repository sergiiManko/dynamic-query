package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import com.mentor.jpa.dynamicquery.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepatmentBySearchData(final SearchData searchData) {
        return departmentRepository.findAll((Specification<Department>) (root, criteriaQuery, criteriaBuilder) -> {
            if (null == searchData.getFieldName() || null == searchData.getValue()) {
                return criteriaBuilder.like("code");
            } else {
                return criteriaBuilder.equal(root.get(searchData.getFieldName()), searchData.getValue());
            }
        });
    }
}
