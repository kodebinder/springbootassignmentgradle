package com.company.testspringbootappgradleassignment.repository;

import com.company.testspringbootappgradleassignment.entity.BaseDbColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDbColumnRepository extends JpaRepository<BaseDbColumn, Long> {
    BaseDbColumn findByName(String name);
}
