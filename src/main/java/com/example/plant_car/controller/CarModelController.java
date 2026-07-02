package com.example.plant_car.controller;


import com.example.plant_car.dto.CarModelDto;
import com.example.plant_car.service.CarModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carmodel")
@RequiredArgsConstructor
public class CarModelController {

    private final CarModelService carModelService;
    @GetMapping()
    public List<CarModelDto> getNotifications() {
        return carModelService.getAllCarModel();
    }
    @PostMapping()
    public  CarModelDto createCarModel(@Valid @RequestBody CarModelDto carModelDto){
        return carModelService.createCarModel(carModelDto);
    }
    @GetMapping("/{id}")
    public CarModelDto getCarModelById(@PathVariable int id){
        return carModelService.getCarModelById(id);
    }
    @PostMapping("/{id}")
    public CarModelDto updateCarModel(@PathVariable int id,@Valid @RequestBody CarModelDto carModelDto){
        return  carModelService.updateCarModel(id, carModelDto);
    }
    @DeleteMapping("/{id}")
    public String deleteCarModel(@PathVariable int id){
         carModelService.deleteCarModel(id);
         return "CarModel deleted Successfully";
    }
    @GetMapping("/{id}/exists")
    public Boolean checkCarModelExists(@PathVariable int id) {
        return carModelService.existsById(id);
    }
}
