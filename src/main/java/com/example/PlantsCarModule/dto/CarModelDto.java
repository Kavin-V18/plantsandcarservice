package com.example.PlantsCarModule.dto;

import com.example.PlantsCarModule.FuelType;
import com.example.PlantsCarModule.Transmission;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;
@Data
public class CarModelDto {
    private String model_name;
    private FuelType fuelType;
    private Transmission transmission;
    private double base_price;
    private List<String> color_options;
    private LocalDate launch_date;
    private boolean is_active;
}
