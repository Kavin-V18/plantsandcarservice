package com.example.PlantsCarModule.service;

import com.example.PlantsCarModule.dto.CarModelDto;
import java.util.List;
public interface CarModelService {
        CarModelDto createCarModel(CarModelDto carModelDto);
        CarModelDto getCarModelById(int id);
        List<CarModelDto> getAllCarModel();
        CarModelDto updateCarModel(int id,CarModelDto carModelDto);
        void deleteCarModel(int id);
}
