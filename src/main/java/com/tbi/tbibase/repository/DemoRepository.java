package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo, Long> {
}
