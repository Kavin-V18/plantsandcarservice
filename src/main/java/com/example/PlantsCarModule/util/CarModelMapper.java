package com.example.PlantsCarModule.util;

import com.example.PlantsCarModule.dto.CarModelDto;
import com.example.PlantsCarModule.entity.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarModelMapper {

     public CarModelDto toDto(CarModel carModel){
         if(carModel==null) return null;
         return CarModelDto.builder().
                 model_name(carModel.getModel_name()).
                 fuelType(carModel.getFuelType()).
                 transmission(carModel.getTransmission()).
                 base_price(carModel.getBase_price()).
                 color_options(carModel.getColor_options()).
                 launch_date(carModel.getLaunch_date()).
                 is_active(carModel.is_active()).
                 created_at(carModel.getCreated_at()).
                 created_by(carModel.getCreated_by()).
                 last_modified_at(carModel.getLast_modified_at()).
                 last_modified_by(carModel.getLast_modified_by()).build();
     }
     public CarModel toEntity(CarModelDto dto){
         if(dto==null) return null;

         CarModel carModel=new CarModel();
         carModel.setModel_name(dto.getModel_name());
         carModel.setFuelType(dto.getFuelType());
         carModel.setTransmission(dto.getTransmission());
         carModel.setColor_options(dto.getColor_options());
         carModel.setLaunch_date(dto.getLaunch_date());
         carModel.set_active(dto.is_active());
         carModel.setBase_price(dto.getBase_price());
         return carModel;
     }
}
