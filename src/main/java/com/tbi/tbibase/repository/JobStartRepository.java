package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.JobStart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JobStartRepository extends JpaRepository<JobStart, Long> {
}
