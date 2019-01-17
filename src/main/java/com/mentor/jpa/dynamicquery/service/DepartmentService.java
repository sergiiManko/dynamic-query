package com.mentor.jpa.dynamicquery.service;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import com.mentor.jpa.dynamicquery.repository.DepartmentRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Kudria
 */
@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartmentBySearchData(final List<SearchData> searchDataList) {
        List<Department> result = new ArrayList<>();
        Specification<Department> specification;
        if (searchDataList != null) {
            specification = Specification.where((Specification<Department>) (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                for (SearchData searchData : searchDataList) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(searchData.getFieldName()).as(String.class)),
                            "%" + searchData.getValue().trim().toLowerCase() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            });
            result = departmentRepository.findAll(specification);
        }
        return result;
    }
}
