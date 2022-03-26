package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.Well;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WellRepository extends JpaRepository<Well, Long> {
}
