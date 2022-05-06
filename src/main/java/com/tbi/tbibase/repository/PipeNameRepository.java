package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.Pipe;
import com.tbi.tbibase.entities.PipeName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PipeNameRepository extends JpaRepository<PipeName, Long> {
}
