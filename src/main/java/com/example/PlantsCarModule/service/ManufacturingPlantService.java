package com.example.PlantsCarModule.service;


import com.example.PlantsCarModule.entity.ManufacturingPlant;
import java.util.List;

public interface ManufacturingPlantService {
    ManufacturingPlant createManufacturingPlant(ManufacturingPlant manufacturingPlant);
    ManufacturingPlant getManufacturingPlantById(int id);
    List<ManufacturingPlant> getAllManufacturingPlant();
    ManufacturingPlant updateManufacturingPlant(int id,ManufacturingPlant manufacturingPlant);
    void deleteManufacturingPlant(int id);
}
