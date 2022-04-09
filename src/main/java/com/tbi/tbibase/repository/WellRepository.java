package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.Well;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface WellRepository extends JpaRepository<Well, Long> {
    public Optional<Well> getWellByWell(String well);
}
