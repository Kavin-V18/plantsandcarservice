package com.example.plant_car.entity;
import com.example.plant_car.FuelType;
import com.example.plant_car.Transmission;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="carmodel",schema="public")
@Data
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class CarModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false,name="model_name")
    private String modelName;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    @Column(nullable = false,name="base_price")
    private double basePrice;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json",name="color_options")
    private List<String> colorOptions;
    @Column(name="launch_date",nullable = false)
    private LocalDate launchDate;
    @ColumnDefault("true")
    @Column(name="is_active")
    private Boolean active;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(name="created_by")
    private Long createdBy;
    @UpdateTimestamp
    @Column(name="last_modified_at")
    private LocalDateTime lastModifiedAt;
    @LastModifiedBy
    @Column(name="last_modified_by")
    private Long lastModifiedBy;
    @Column(insertable=false, updatable=false)
    private Boolean deleted;
}
