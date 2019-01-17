package com.mentor.jpa.dynamicquery.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Artem Kudria
 */
@NoArgsConstructor
@Getter
@Setter
public final class SearchDataDepartment extends SearchData {
    private String nameTable;

    public SearchDataDepartment(String fieldName, String value) {
        super(fieldName, value);
        this.nameTable = "department";
    }
}
