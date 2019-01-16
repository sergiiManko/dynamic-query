package com.mentor.jpa.dynamicquery.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Artem Kudria
 */
@AllArgsConstructor
@NoArgsConstructor
public final class SearchDataEmployee extends SearchData {
    public SearchDataEmployee(String fieldName, String value) {
        super(fieldName, value);
    }
}
