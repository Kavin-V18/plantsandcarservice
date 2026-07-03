package com.example.plant_car.repository;

import com.example.plant_car.entity.CarModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CarModelRepository extends JpaRepository<CarModel,Integer> {
}
