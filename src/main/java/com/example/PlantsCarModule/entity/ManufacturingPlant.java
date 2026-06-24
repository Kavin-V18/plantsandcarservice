package com.example.PlantsCarModule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="maufacturingplant",schema="public")
@Data
public class ManufacturingPlant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    @NotNull
    private String name;
    @Column(nullable = false, unique = true)
    @NotNull
    private String code;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    @Min(1)
    private int capacity_per_day;
    @ColumnDefault("true")
    private boolean is_active;
    private String created_by;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    private String last_modified_by;
}
