package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sorting.Sorter;

public interface Pageable {
    Integer getPage();
    Integer getOffset();
    Integer getLimit();
    Sorter getSorter();
}
