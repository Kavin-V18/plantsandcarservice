package com.example.PlantsCarModule.controller;


import com.example.PlantsCarModule.entity.CarModel;
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
    public List<CarModel> getNotifications() {
        return carModelService.getAllCarModel();
    }
    @PostMapping()
    public  CarModel createNotification(@Valid @RequestBody CarModel carModel){
        return carModelService.createCarModel(carModel);
    }
    @GetMapping("/{id}")
    public CarModel getNotificationById(@PathVariable int id){
        return carModelService.getCarModelById(id);
    }
    @PostMapping("/{id}")
    public CarModel updateNotification(@PathVariable int id,@Valid @RequestBody CarModel carModel){
        return  carModelService.updateCarModel(id, carModel);
    }
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable int id){
         carModelService.deleteCarModel(id);
    }
}
