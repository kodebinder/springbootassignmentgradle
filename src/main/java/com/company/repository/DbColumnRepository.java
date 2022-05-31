package com.company.repository;

import com.company.entity.DbColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbColumnRepository extends JpaRepository<DbColumn, Long> {
}
