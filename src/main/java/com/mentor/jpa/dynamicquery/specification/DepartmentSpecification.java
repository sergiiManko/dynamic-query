package com.mentor.jpa.dynamicquery.specification;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Department;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Sergii Manko
 */
@NoArgsConstructor
public class DepartmentSpecification implements Specification<Department> {
    private SearchData searchData = null;

    public DepartmentSpecification(final SearchData searchData) {
        this.searchData = searchData;
    }

    @Override
    public Predicate toPredicate(final Root<Department> root, final CriteriaQuery<?> criteriaQuery, final CriteriaBuilder criteriaBuilder) {
        if (searchData != null) {
            return criteriaBuilder.like(criteriaBuilder.lower(root.get(searchData.getFieldName()).as(String.class)),
                    "%" + searchData.getValue().trim().toLowerCase() + "%");
        }
        return null;
    }
}
