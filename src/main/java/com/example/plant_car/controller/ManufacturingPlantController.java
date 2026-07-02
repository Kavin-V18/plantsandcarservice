package com.example.plant_car.controller;

import com.example.plant_car.dto.ManufacturingPlantDto;
import com.example.plant_car.service.ManufacturingPlantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturingplant")
@RequiredArgsConstructor
public class ManufacturingPlantController {

    private final ManufacturingPlantService manufacturingPlantService;
    @GetMapping()
    public List<ManufacturingPlantDto> getManufacturingPlant() {
        return manufacturingPlantService.getAllManufacturingPlant();
    }
    @PostMapping()
    public  ManufacturingPlantDto createManufacturingPlant(@Valid @RequestBody ManufacturingPlantDto manufacturingPlantDto){
        return manufacturingPlantService.createManufacturingPlant(manufacturingPlantDto);
    }
    @GetMapping("/{id}")
    public ManufacturingPlantDto getManufacturingPlantById(@PathVariable int id){
        return manufacturingPlantService.getManufacturingPlantById(id);
    }
    @PostMapping("/{id}")
    public ManufacturingPlantDto updateManufacturingPlant(@PathVariable int id,@Valid @RequestBody ManufacturingPlantDto manufacturingPlantDto){
        return  manufacturingPlantService.updateManufacturingPlant(id, manufacturingPlantDto);
    }
    @DeleteMapping("/{id}")
    public void deleteManufacturingPlant(@PathVariable int id){
        manufacturingPlantService.deleteManufacturingPlant(id);
    }
    @GetMapping("/{id}/exists")
    public Boolean checkManufacturingPlantExists(@PathVariable int id) {
        return manufacturingPlantService.existsById(id);
    }
}
