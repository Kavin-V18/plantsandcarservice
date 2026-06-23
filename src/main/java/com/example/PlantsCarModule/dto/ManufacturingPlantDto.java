package com.example.PlantsCarModule.dto;

import lombok.Data;

@Data
public class ManufacturingPlantDto {
    private String name;
    private String code;
    private String location;
    private int capacity_per_day;
    private boolean is_active;
    //need to map employee
}
