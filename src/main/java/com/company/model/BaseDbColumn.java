package com.company.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BaseDbColumn {

    private String name;
    private String label;
    private String type;
    private List<List<String>> groupedValues;

    public BaseDbColumn() {

    }

    public BaseDbColumn(String name, String label, String type, List<List<String>> groupedValues) {
        this.name = name;
        this.label = label;
        this.type = type;
        this.groupedValues = groupedValues;
    }
}
