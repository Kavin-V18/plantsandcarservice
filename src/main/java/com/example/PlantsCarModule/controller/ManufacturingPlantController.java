package com.example.PlantsCarModule.controller;

import com.example.PlantsCarModule.dto.ManufacturingPlantDto;
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
    public List<ManufacturingPlantDto> getNotifications() {
        return manufacturingPlantService.getAllManufacturingPlant();
    }
    @PostMapping()
    public  ManufacturingPlantDto createNotification(@Valid @RequestBody ManufacturingPlantDto manufacturingPlantDto){
        return manufacturingPlantService.createManufacturingPlant(manufacturingPlantDto);
    }
    @GetMapping("/{id}")
    public ManufacturingPlantDto getNotificationById(@PathVariable int id){
        return manufacturingPlantService.getManufacturingPlantById(id);
    }
    @PostMapping("/{id}")
    public ManufacturingPlantDto updateNotification(@PathVariable int id,@Valid @RequestBody ManufacturingPlantDto manufacturingPlantDto){
        return  manufacturingPlantService.updateManufacturingPlant(id, manufacturingPlantDto);
    }
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable int id){
        manufacturingPlantService.deleteManufacturingPlant(id);
    }
}
