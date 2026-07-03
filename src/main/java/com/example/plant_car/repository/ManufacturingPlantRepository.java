package com.example.plant_car.repository;

import com.example.plant_car.entity.ManufacturingPlant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ManufacturingPlantRepository extends JpaRepository<ManufacturingPlant,Integer> {
}
