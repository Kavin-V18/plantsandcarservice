package com.example.PlantsCarModule.entity;

import com.example.PlantsCarModule.FuelType;
import com.example.PlantsCarModule.Transmission;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="carmodel",schema="public")
@Data
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String model_name;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Column(nullable = false)
    @Min(1)
    private double base_price;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> color_options;

    @Column(nullable = false)
    private LocalDate launch_date;

    @ColumnDefault("true")
    private boolean is_active;
}
