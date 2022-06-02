package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dummy {
    private long id;
    private String dummyField1;
    private String dummyField2;
    private String dummyField3;
}
