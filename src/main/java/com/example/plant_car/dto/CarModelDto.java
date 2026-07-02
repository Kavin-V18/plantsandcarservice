package com.example.plant_car.dto;

import com.example.plant_car.FuelType;
import com.example.plant_car.Transmission;
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
    private String modelName;
    private FuelType fuelType;
    private Transmission transmission;
    private double basePrice;
    private List<String> colorOptions;
    private LocalDate launchDate;
    @ColumnDefault("true")
    private Boolean active;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
    private Boolean deleted;
}
