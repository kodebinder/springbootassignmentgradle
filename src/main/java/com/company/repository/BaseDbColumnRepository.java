package com.company.repository;

import com.company.entity.BaseDbColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDbColumnRepository extends JpaRepository<BaseDbColumn, Long> {
    BaseDbColumn findByName(String name);
}
