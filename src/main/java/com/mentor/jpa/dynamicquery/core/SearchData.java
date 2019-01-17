package com.mentor.jpa.dynamicquery.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * POJO class needed for store information about search data.
 *
 * @author Sergii Manko
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class SearchData {
    private String fieldName;
    private String value;
}
