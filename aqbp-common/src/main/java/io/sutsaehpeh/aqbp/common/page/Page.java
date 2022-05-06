package io.sutsaehpeh.aqbp.common.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {

    private int pageSize;

    private int pageNumber;

    private int totalPages;

    private List<T> element;

    private Sort sort;
}
