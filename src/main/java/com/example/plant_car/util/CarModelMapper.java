package com.example.plant_car.util;

import com.example.plant_car.dto.CarModelDto;
import com.example.plant_car.entity.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarModelMapper {

     public CarModelDto toDto(CarModel carModel){
         if(carModel==null) return null;
         return CarModelDto.builder().
                 modelName(carModel.getModelName()).
                 fuelType(carModel.getFuelType()).
                 transmission(carModel.getTransmission()).
                 basePrice(carModel.getBasePrice()).
                 colorOptions(carModel.getColorOptions()).
                 launchDate(carModel.getLaunchDate()).
                 active(carModel.getActive()).
                 createdAt(carModel.getCreatedAt()).
                 createdBy(carModel.getCreatedBy()).
                 lastModifiedAt(carModel.getLastModifiedAt()).
                 lastModifiedBy(carModel.getLastModifiedBy()).build();
     }
     public CarModel toEntity(CarModelDto dto){
         if(dto==null) return null;

         CarModel carModel=new CarModel();
         carModel.setModelName(dto.getModelName());
         carModel.setFuelType(dto.getFuelType());
         carModel.setTransmission(dto.getTransmission());
         carModel.setColorOptions(dto.getColorOptions());
         carModel.setLaunchDate(dto.getLaunchDate());
         carModel.setActive(dto.getActive());
         carModel.setBasePrice(dto.getBasePrice());
         return carModel;
     }
}
