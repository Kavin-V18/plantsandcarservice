package com.example.plant_car.service;

import com.example.plant_car.dto.CarModelDto;
import java.util.List;
public interface CarModelService {
        CarModelDto createCarModel(CarModelDto carModelDto);
        CarModelDto getCarModelById(int id);
        List<CarModelDto> getAllCarModel();
        CarModelDto updateCarModel(int id,CarModelDto carModelDto);
        void deleteCarModel(int id);
    Boolean existsById(int id);
}
