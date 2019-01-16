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
 * @author Artem Kudria
 */
@NoArgsConstructor
public class EmployeeSpecification implements Specification<Employee> {
    private transient SearchData searchData;

    public EmployeeSpecification(SearchData searchData) {
        this.searchData = searchData;
    }

    /**
     * Find into data base employee for name and code department
     *
     * @param root            Root
     * @param criteriaQuery   Query for search
     * @param criteriaBuilder CriteriaBuilder
     * @return Predicate
     */
    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (searchData != null) {
            switch (searchData.getFieldName()) {
                case "name":
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get(searchData.getFieldName()).as(String.class)),
                            "%" + searchData.getValue().trim().toLowerCase() + "%");

                case "code":
                    return criteriaBuilder
                            .like(root.join("department")
                                            .get(searchData.getFieldName()).as(String.class),
                                    "%" + searchData.getValue().trim().toLowerCase() + "%");

                default:
                    return null;
            }
        }
        return null;
    }
}
