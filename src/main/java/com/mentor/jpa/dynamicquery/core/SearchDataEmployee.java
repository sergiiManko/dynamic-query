package com.mentor.jpa.dynamicquery.core;

import lombok.NoArgsConstructor;

/**
 * @author Artem Kudria
 */
@NoArgsConstructor
public final class SearchDataEmployee extends SearchData {
    public SearchDataEmployee(String fieldName, String value) {
        super(fieldName, value);
    }
}
