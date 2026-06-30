package com.example.PlantsCarModule.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="maufacturingplant",schema="public")
@Data
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
    @Column(nullable = false)
    private int capacity_per_day;
    @ColumnDefault("true")
    private boolean is_active;
    @CreatedBy
    private String created_by;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @LastModifiedBy
    private String last_modified_by;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
