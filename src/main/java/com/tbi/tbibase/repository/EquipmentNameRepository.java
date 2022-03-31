package com.tbi.tbibase.repository;

import com.tbi.tbibase.entities.Equipment;
import com.tbi.tbibase.entities.EquipmentName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentNameRepository extends JpaRepository<EquipmentName, Long> {
}
