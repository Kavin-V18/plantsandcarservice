package com.example.PlantsCarModule.controller;


import com.example.PlantsCarModule.dto.CarModelDto;
import com.example.PlantsCarModule.service.CarModelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carmodel")
public class CarModelController {

    private final CarModelService carModelService;
    public CarModelController(CarModelService carModelService){
        this.carModelService=carModelService;
    }
    @GetMapping()
    public List<CarModelDto> getNotifications() {
        return carModelService.getAllCarModel();
    }
    @PostMapping()
    public  CarModelDto createNotification(@Valid @RequestBody CarModelDto carModelDto){
        return carModelService.createCarModel(carModelDto);
    }
    @GetMapping("/{id}")
    public CarModelDto getNotificationById(@PathVariable int id){
        return carModelService.getCarModelById(id);
    }
    @PostMapping("/{id}")
    public CarModelDto updateNotification(@PathVariable int id,@Valid @RequestBody CarModelDto carModelDto){
        return  carModelService.updateCarModel(id, carModelDto);
    }
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id){
         carModelService.deleteCarModel(id);
         return "CarModel deleted Successfully";
    }
}
