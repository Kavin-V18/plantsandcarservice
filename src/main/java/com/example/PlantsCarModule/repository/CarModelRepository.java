package com.example.PlantsCarModule.repository;

import com.example.PlantsCarModule.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel,Integer> {
}
