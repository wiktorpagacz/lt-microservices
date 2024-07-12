package com.pagacz.progtrack.repository;

import com.pagacz.progtrack.entity.ProgressEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<ProgressEntry, Long> {
}
