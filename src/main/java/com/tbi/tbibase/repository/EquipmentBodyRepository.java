package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.EquipmentBody;
import com.tbi.tbibase.entities.EquipmentName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentBodyRepository extends JpaRepository<EquipmentBody, Long> {
}
