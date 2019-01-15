package com.mentor.jpa.dynamicquery.specification;

import com.mentor.jpa.dynamicquery.domain.Department;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Sergii Manko
 */
public class DepartmentSpecification {
    public static Specification<Department> departmantEqualsName(final String code) {
        return new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
    }
}
