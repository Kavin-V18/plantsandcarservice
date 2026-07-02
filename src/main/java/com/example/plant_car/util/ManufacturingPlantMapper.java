package com.example.plant_car.util;

import com.example.plant_car.dto.ManufacturingPlantDto;
import com.example.plant_car.entity.ManufacturingPlant;
import org.springframework.stereotype.Component;

@Component
public class ManufacturingPlantMapper {


    public ManufacturingPlantDto toDto(ManufacturingPlant manufacturingPlant) {
        if (manufacturingPlant == null) return null;

        return ManufacturingPlantDto.builder().
                name(manufacturingPlant.getName()).
                code(manufacturingPlant.getCode()).
                capacityPerDay(manufacturingPlant.getCapacityPerDay()).
                active(manufacturingPlant.getActive()).
                createdAt(manufacturingPlant.getCreatedAt()).
                createdBy(manufacturingPlant.getCreatedBy()).
                lastModifiedAt(manufacturingPlant.getLastModifiedAt()).
                lastModifiedBy(manufacturingPlant.getLastModifiedBy()).build();
    }

    public ManufacturingPlant toEntity(ManufacturingPlantDto dto) {
        if (dto == null) return null;

        ManufacturingPlant manufacturingPlant = new ManufacturingPlant();
        manufacturingPlant.setName(dto.getName());
        manufacturingPlant.setCode(dto.getCode());
        manufacturingPlant.setCapacityPerDay(dto.getCapacityPerDay());
        manufacturingPlant.setLocation(dto.getLocation());
        manufacturingPlant.setActive(dto.getActive());
        return manufacturingPlant;
    }
}
