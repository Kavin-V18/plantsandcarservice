package com.example.plant_car.service;
import com.example.plant_car.dto.ManufacturingPlantDto;
import java.util.List;

public interface ManufacturingPlantService {
    ManufacturingPlantDto createManufacturingPlant(ManufacturingPlantDto manufacturingPlantDto);
    ManufacturingPlantDto getManufacturingPlantById(int id);
    List<ManufacturingPlantDto> getAllManufacturingPlant();
    ManufacturingPlantDto updateManufacturingPlant(int id,ManufacturingPlantDto manufacturingPlantDto);
    void deleteManufacturingPlant(int id);
    Boolean existsById(int id);
}
