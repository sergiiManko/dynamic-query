package com.mentor.jpa.dynamicquery.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Artem Kudria
 */
@AllArgsConstructor
@NoArgsConstructor
public final class SearchDataDepartment extends SearchData {
    public SearchDataDepartment(String fieldName, String value) {
        super(fieldName, value);
    }
}
