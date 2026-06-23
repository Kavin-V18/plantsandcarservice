package com.example.PlantsCarModule.service;

import com.example.PlantsCarModule.entity.CarModel;

import java.util.List;

public interface CarModelService {
        CarModel createCarModel(CarModel carModel);
        CarModel getCarModelById(int id);
        List<CarModel> getAllCarModel();
        CarModel updateCarModel(int id,CarModel carModel);
        void deleteCarModel(int id);
}
