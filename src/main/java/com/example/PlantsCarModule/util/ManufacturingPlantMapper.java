package com.example.PlantsCarModule.util;

import com.example.PlantsCarModule.dto.ManufacturingPlantDto;
import com.example.PlantsCarModule.entity.ManufacturingPlant;
import org.springframework.stereotype.Component;

@Component
public class ManufacturingPlantMapper {


    public ManufacturingPlantDto toDto(ManufacturingPlant manufacturingPlant) {
        if (manufacturingPlant == null) return null;

        return ManufacturingPlantDto.builder().
                name(manufacturingPlant.getName()).
                code(manufacturingPlant.getCode()).
                capacity_per_day(manufacturingPlant.getCapacity_per_day()).
                is_active(manufacturingPlant.is_active()).
                created_at(manufacturingPlant.getCreated_at()).
                created_by(manufacturingPlant.getCreated_by()).
                last_modified_at(manufacturingPlant.getLast_modified_at()).
                last_modified_by(manufacturingPlant.getLast_modified_by()).build();
    }

    public ManufacturingPlant toEntity(ManufacturingPlantDto dto) {
        if (dto == null) return null;

        ManufacturingPlant manufacturingPlant = new ManufacturingPlant();
        manufacturingPlant.setName(dto.getName());
        manufacturingPlant.setCode(dto.getCode());
        manufacturingPlant.setCapacity_per_day(dto.getCapacity_per_day());
        manufacturingPlant.setLocation(dto.getLocation());
        manufacturingPlant.set_active(dto.is_active());
        return manufacturingPlant;
    }
}
