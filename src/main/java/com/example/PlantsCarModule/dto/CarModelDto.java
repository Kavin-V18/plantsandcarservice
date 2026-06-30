package com.example.PlantsCarModule.dto;

import com.example.PlantsCarModule.FuelType;
import com.example.PlantsCarModule.Transmission;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDto {
    @NotNull
    private String model_name;
    private FuelType fuelType;
    private Transmission transmission;
    private double base_price;
    private List<String> color_options;
    private LocalDate launch_date;
    @ColumnDefault("true")
    private boolean is_active;
    private LocalDateTime created_at;
    private Long created_by;
    private LocalDateTime last_modified_at;
    private Long last_modified_by;
}
