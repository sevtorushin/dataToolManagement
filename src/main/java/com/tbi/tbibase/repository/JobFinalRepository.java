package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.JobFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JobFinalRepository extends JpaRepository<JobFinal, Long> {
}
