package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.Pipe;
import com.tbi.tbibase.entities.PipeName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PipeRepository extends JpaRepository<Pipe, Long> {
    List<Pipe> getPipeByPipeName(PipeName pipeName);
}
