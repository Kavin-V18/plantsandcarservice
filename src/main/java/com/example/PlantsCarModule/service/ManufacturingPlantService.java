package com.example.PlantsCarModule.service;


import com.example.PlantsCarModule.dto.ManufacturingPlantDto;
import java.util.List;

public interface ManufacturingPlantService {
    ManufacturingPlantDto createManufacturingPlant(ManufacturingPlantDto manufacturingPlantDto);
    ManufacturingPlantDto getManufacturingPlantById(int id);
    List<ManufacturingPlantDto> getAllManufacturingPlant();
    ManufacturingPlantDto updateManufacturingPlant(int id,ManufacturingPlantDto manufacturingPlantDto);
    void deleteManufacturingPlant(int id);
}
