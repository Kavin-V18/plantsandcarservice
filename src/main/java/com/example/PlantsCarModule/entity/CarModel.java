package com.example.PlantsCarModule.entity;

import com.example.PlantsCarModule.FuelType;
import com.example.PlantsCarModule.Transmission;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="carmodel",schema="public")
@Data
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class CarModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String model_name;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    @Column(nullable = false)
    private double base_price;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> color_options;
    @Column(nullable = false)
    private LocalDate launch_date;
    @ColumnDefault("true")
    private boolean is_active;
    @CreationTimestamp
    private LocalDateTime created_at;
    @CreatedBy
    private Long created_by;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @LastModifiedBy
    private Long last_modified_by;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
