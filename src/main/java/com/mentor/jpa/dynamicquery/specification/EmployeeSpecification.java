package com.mentor.jpa.dynamicquery.specification;

import com.mentor.jpa.dynamicquery.core.SearchData;
import com.mentor.jpa.dynamicquery.domain.Employee;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Nikita Blizniukov
 */
@NoArgsConstructor
public class EmployeeSpecification implements Specification<Employee> {

    private transient SearchData searchData;

    public EmployeeSpecification(final SearchData searchData) {
        this.searchData = searchData;
    }

    @Override
    public Predicate toPredicate(final Root<Employee> root, final CriteriaQuery<?> query,
                                 final CriteriaBuilder criteriaBuilder) {
        if (searchData != null) {
            return criteriaBuilder.like(criteriaBuilder.lower(root
                            .join("department")
                            .get(searchData.getFieldName())
                            .as(String.class)),
                    "%" + searchData.getValue().toLowerCase() + "%");
        }
        return null;
    }
}
