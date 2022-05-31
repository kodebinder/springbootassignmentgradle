package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class DbColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String label;
    private String type;
    @Transient
    private List<List<String>> groupedValues;
}
