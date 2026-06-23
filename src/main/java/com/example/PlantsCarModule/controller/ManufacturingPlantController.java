package com.example.PlantsCarModule.controller;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.PlantsCarModule.entity.ManufacturingPlant;
import com.example.PlantsCarModule.service.CarModelService;
import com.example.PlantsCarModule.service.ManufacturingPlantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturingplant")
public class ManufacturingPlantController {

    private final ManufacturingPlantService manufacturingPlantService;
    public ManufacturingPlantController(ManufacturingPlantService manufacturingPlantService){
        this.manufacturingPlantService=manufacturingPlantService;
    }
    @GetMapping()
    public List<ManufacturingPlant> getNotifications() {
        return manufacturingPlantService.getAllManufacturingPlant();
    }
    @PostMapping()
    public  ManufacturingPlant createNotification(@Valid @RequestBody ManufacturingPlant manufacturingPlant){
        return manufacturingPlantService.createManufacturingPlant(manufacturingPlant);
    }
    @GetMapping("/{id}")
    public ManufacturingPlant getNotificationById(@PathVariable int id){
        return manufacturingPlantService.getManufacturingPlantById(id);
    }
    @PostMapping("/{id}")
    public ManufacturingPlant updateNotification(@PathVariable int id,@Valid @RequestBody ManufacturingPlant manufacturingPlant){
        return  manufacturingPlantService.updateManufacturingPlant(id, manufacturingPlant);
    }
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable int id){
        manufacturingPlantService.deleteManufacturingPlant(id);
    }
}
