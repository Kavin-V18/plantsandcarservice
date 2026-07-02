package com.example.plant_car.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name="maufacturingplant",schema="public")
@Data
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class ManufacturingPlant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false,name="capacity_per_day")
    private Integer capacityPerDay;
    @ColumnDefault("true")
    @Column(name="is_active")
    private Boolean active;
    @CreatedBy
    @Column(name="created_by")
    private Long createdBy;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name="last_modified_at")
    private LocalDate lastModifiedAt;
    @LastModifiedBy
    @Column(name="last_modified_by")
    private Long lastModifiedBy;
    @Column(insertable=false, updatable=false)
    private Boolean deleted;
}
